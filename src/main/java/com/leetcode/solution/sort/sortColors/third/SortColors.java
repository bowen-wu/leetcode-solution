package com.leetcode.solution.sort.sortColors.third;

import com.leetcode.solution.sort.sortColors.SortColorsTemplate;

public class SortColors extends SortColorsTemplate {
    @Override
    public void sortColors(int[] nums) {
        // Ideas: Three pointer
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        // 0 position
        int start = 0;

        // 2 position
        int end = nums.length - 1;

        for (int i = 0; i <= end;) {
            if (nums[i] == 0) {
                swap(nums, start, i);
                start++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, end, i);
                end--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
