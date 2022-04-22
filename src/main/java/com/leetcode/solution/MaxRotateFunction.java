package com.leetcode.solution;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-function/
 * 396. 旋转函数
 */
public class MaxRotateFunction {
    public static void main(String[] args) {
        System.out.println(new MaxRotateFunction().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    // 时间复杂度：O(n * n)
    // 空间复杂度：O(n)
    public int maxRotateFunction(int[] nums) {
        int length = nums.length;
        int[] resultArr = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // [F(0), F(1), F(2), F(3)]
                int coefficient = (i + j >= length) ? (i + j - length) : (i + j);
                resultArr[j] += coefficient * nums[i];
            }
        }
        Arrays.sort(resultArr);
        return resultArr[length - 1];
    }
}
