package com.leetcode.solution.array.sortArrayByParity.third;

import com.leetcode.solution.array.sortArrayByParity.SortArrayByParityTemplate;

public class SortArrayByParity extends SortArrayByParityTemplate {
    @Override
    public int[] sortArrayByParity(int[] nums) {
        // 思路
        // 双指针 => leftPoint + rightPoint，循环遍历数组，如果是偶数，放置在 leftPoint++ 上，如果是奇数，放置在 rightPoint++ 上。O(n) + O(n)
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[leftPoint++] = nums[i];
            } else {
                result[rightPoint--] = nums[i];
            }
        }

        return result;
    }
}
