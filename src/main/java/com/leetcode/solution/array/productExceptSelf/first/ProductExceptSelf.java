package com.leetcode.solution.array.productExceptSelf.first;

import com.leetcode.solution.array.productExceptSelf.ProductExceptSelfTemplate;

public class ProductExceptSelf extends ProductExceptSelfTemplate {
    @Override
    public int[] productExceptSelf(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        // 优化空间 =>
        //   1. result 代替 leftPrefixMultiple
        //   2. factor 代替 rightPrefixMultiple
        // 第i个结果 answer[i] == answer[i] * factor
        // nums   =>  1  2  3  4
        // answer =>  1  1  2  6
        // factor = 1
        // i = 3
        // answer =>  1  1  2  6*1
        // factor = 1 * 4 = 4
        // i = 2
        // answer =>  1  1  2*4 6
        // factor = 4 * 3 = 12
        // i = 1
        // answer =>  1 1*12 8  6
        // factor = 12 * 2 = 24
        // i = 0
        // answer =>  24 12 8  6
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int factor = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * factor;
            factor *= nums[i];
        }

        return answer;
    }

    public int[] productExceptSelfSpace(int[] nums) {
        // 第i个结果 answer[i] == left[i] * right[i]
        // nums =>  1  2  3  4
        // left =>  1  1  2  6
        // right => 24 12 4  1
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] leftPrefixMultiple = new int[nums.length];
        leftPrefixMultiple[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftPrefixMultiple[i] = leftPrefixMultiple[i - 1] * nums[i - 1];
        }

        int[] rightPrefixMultiple = new int[nums.length];
        rightPrefixMultiple[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightPrefixMultiple[i] = rightPrefixMultiple[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftPrefixMultiple[i] * rightPrefixMultiple[i];
        }

        return result;
    }

    public int[] productExceptSelfBefore(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        // 第i个结果 answer[i] == positive[i] * reverse[nums.length - i - 1]
        // nums     =>     1  2  3  4
        // positive =>  1  1  1  2  6
        // reverse  =>  1  4  12 24 24
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] positivePrefixMultiple = new int[nums.length + 1];
        positivePrefixMultiple[0] = 1;

        int[] reversePrefixMultiple = new int[nums.length + 1];
        reversePrefixMultiple[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            positivePrefixMultiple[i + 1] = positivePrefixMultiple[i] * nums[i];
            reversePrefixMultiple[i + 1] = reversePrefixMultiple[i] * nums[nums.length - 1 - i];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = positivePrefixMultiple[i] * reversePrefixMultiple[nums.length - i - 1];
        }

        return result;
    }
}
