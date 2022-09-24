package com.leetcode.solution.sort.kthLargestElementInAnArray.second;

import com.leetcode.solution.sort.kthLargestElementInAnArray.FindKthLargestTemplate;

public class FindKthLargest extends FindKthLargestTemplate {
    @Override
    public int findKthLargest(int[] nums, int k) {
        // Ideas: quick select => 第k大，第 nums.length - k + 1 小
        if (nums == null || nums.length == 0 || k < 1) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int index) {
        if (start == end) {
            return nums[start];
        }

        int pivot = partition(nums, start, end);
        if (pivot == index) {
            return nums[pivot];
        }
        if (pivot < index) {
            // 高区
            return quickSelect(nums, pivot + 1, end, index);
        }

        // 低区
        return quickSelect(nums, start, pivot - 1, index);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // j 是第一个小于 pivotValue 的位置
        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;

                // 之前有值大于 pivotValue
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, j + 1, end);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
