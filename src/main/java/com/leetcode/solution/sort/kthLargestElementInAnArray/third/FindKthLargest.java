package com.leetcode.solution.sort.kthLargestElementInAnArray.third;

import com.leetcode.solution.sort.kthLargestElementInAnArray.FindKthLargestTemplate;

public class FindKthLargest extends FindKthLargestTemplate {
    @Override
    public int findKthLargest(int[] nums, int k) {
        // Ideas: Quick Sort
        // check input
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }

        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }

        int pivot = partition(nums, start, end);
        if (pivot == k) {
            return nums[pivot];
        }
        if (pivot < k) {
            // 高区
            return quickSort(nums, pivot + 1, end, k);
        }
        return quickSort(nums, start, pivot - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // 最后一个小于 pivotValue 的位置
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivotValue) {
                j++;
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, end, j + 1);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
