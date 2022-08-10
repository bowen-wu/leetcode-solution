package com.leetcode.solution.array.productExceptSelf.third;

import com.leetcode.solution.array.productExceptSelf.ProductExceptSelfTemplate;

public class ProductExceptSelf extends ProductExceptSelfTemplate {
    @Override
    public int[] productExceptSelf(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
