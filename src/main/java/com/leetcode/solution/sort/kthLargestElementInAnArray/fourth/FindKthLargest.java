package com.leetcode.solution.sort.kthLargestElementInAnArray.fourth;

import com.leetcode.solution.sort.kthLargestElementInAnArray.FindKthLargestTemplate;

public class FindKthLargest extends FindKthLargestTemplate {
    @Override
    public int findKthLargest(int[] nums, int k) {
        // Ideas: Quick Sort
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int targetIndex) {
        if (start >= end) {
            return nums[start];
        }

        int pivot = partition(nums, start, end);
        if (pivot == targetIndex) {
            return nums[pivot];
        }
        if (pivot > targetIndex) {
            // left
            return quickSelect(nums, start, pivot - 1, targetIndex);
        } else {
            // right
            return quickSelect(nums, pivot + 1, end, targetIndex);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // j 指向第一个小于 pivotValue 的位置
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, end, j + 1);
        return j + 1;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
