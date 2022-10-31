package com.leetcode.solution.sort.sortColors.fourth;

import com.leetcode.solution.sort.sortColors.SortColorsTemplate;

public class SortColors extends SortColorsTemplate {
    @Override
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 2) {
                swap(nums, i, right);
                while (i <= right && nums[right] == 2) {
                    right--;
                }
            } else if (nums[i] == 0) {
                if (i != left) {
                    swap(nums, i, left);
                }

                i++;
                left++;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
