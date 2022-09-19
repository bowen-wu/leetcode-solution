package com.leetcode.solution.sort.shuZuZhongDeNiXuDuiLcof.first;

import com.leetcode.solution.sort.shuZuZhongDeNiXuDuiLcof.ReversePairsTemplate;

public class ReversePairs extends ReversePairsTemplate {
    @Override
    public int reversePairs(int[] nums) {
        // Ideas: 归并排序中 nums[left] > nums[right] 时 leftLength - left 的个数就是 left 位置的逆序对数
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = mergeSort(nums, temp, start, mid);
        int right = mergeSort(nums, temp, mid + 1, end);
        return mergeTwoSortedArray(nums, temp, start, mid, end) + left + right;
    }

    private int mergeTwoSortedArray(int[] nums, int[] temp, int start, int mid, int end) {
        // merge two sorted array
        int left = start;
        int right = mid + 1;
        int index = start;
        int result = 0;

        while (left <= mid && right <= end) {
            if (nums[left] > nums[right]) {
                result += mid + 1 - left;
                temp[index++] = nums[right++];
            } else {
                temp[index++] = nums[left++];
            }
        }

        // remaining
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }

        // copy
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
        return result;
    }

}
