package com.leetcode.solution.sort.sortColors.second;

import com.leetcode.solution.sort.sortColors.SortColorsTemplate;

public class SortColors extends SortColorsTemplate {
    @Override
    public void sortColors(int[] nums) {
        // Ideas: 三指针 => 第一根指0，第二根指2，第三根移动
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0;
        int end = nums.length - 1;
        for (int i = start; i <= end; ) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else {
                // nums[i] == 1
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
