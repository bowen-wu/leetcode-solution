package com.leetcode.solution.sort.sortColors.first;

import com.leetcode.solution.sort.sortColors.SortColorsTemplate;

public class SortColors extends SortColorsTemplate {
    @Override
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int i = start;
        while (i <= end) {
            if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 0
                swap(nums, i, start);
                start++;
                i++;
            }
        }

    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    public void sortColorsTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }

        int index = 0;
        for (int i = 0; i < zero; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < one; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < two; i++) {
            nums[index++] = 2;
        }
    }
}
