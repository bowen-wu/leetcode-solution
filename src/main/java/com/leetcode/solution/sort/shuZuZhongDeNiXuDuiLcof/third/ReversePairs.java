package com.leetcode.solution.sort.shuZuZhongDeNiXuDuiLcof.third;

import com.leetcode.solution.sort.shuZuZhongDeNiXuDuiLcof.ReversePairsTemplate;

public class ReversePairs extends ReversePairsTemplate {
    @Override
    public int reversePairs(int[] nums) {
        // Ideas: Merge Sort
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int left = mergeSort(nums, start, mid, temp);
        int right = mergeSort(nums, mid + 1, end, temp);
        return mergeTwoSortedArray(nums, start, mid, end, temp) + left + right;
    }

    private int mergeTwoSortedArray(int[] nums, int start, int mid, int end, int[] temp) {
        int index = start;
        int first = start;
        int second = mid + 1;
        int result = 0;
        while (first <= mid && second <= end) {
            if (nums[first] > nums[second]) {
                result += mid - first + 1;
                temp[index++] = nums[second++];
            } else {
                temp[index++] = nums[first++];
            }
        }

        // remaining
        while (first <= mid) {
            temp[index++] = nums[first++];
        }
        while (second <= end) {
            temp[index++] = nums[second++];
        }

        // copy
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
        return result;
    }
}
