package com.leetcode.solution.sort.reversePairs.fourth;

import com.leetcode.solution.sort.shuZuZhongDeNiXuDuiLcof.ReversePairsTemplate;

public class ReversePairs extends ReversePairsTemplate {
    @Override
    public int reversePairs(int[] nums) {
        // Ideas: Merge Sort
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

        int middle = start + (end - start) / 2;
        int left = mergeSort(nums, start, middle, temp);
        int right = mergeSort(nums, middle + 1, end, temp);
        return merge(nums, start, middle, end, temp) + left + right;
    }

    private int merge(int[] nums, int start, int middle, int end, int[] temp) {
        int result = 0;
        int first = start;
        int second = middle + 1;
        while (first <= middle && second <= end) {
            // first < second && nums[first] > 2 * nums[second]
            if (nums[first] > 2.0 * nums[second]) {
                result += middle - first + 1;
                second++;
            } else {
                first++;
            }
        }

        first = start;
        second = middle + 1;
        int index = start;
        while (first <= middle && second <= end) {
            if (nums[first] > nums[second]) {
                temp[index++] = nums[second++];
            } else {
                temp[index++] = nums[first++];
            }
        }

        // remaining
        while (first <= middle) {
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
