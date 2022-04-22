package com.leetcode.solution;

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
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, rotateF(nums, i));
        }
        return result;
    }

    public int rotateF(int[] nums, int rotateNumber) {
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int coefficient = (i + rotateNumber >= length) ? (i + rotateNumber - length) : (i + rotateNumber);
            result += (coefficient * nums[i]);
        }
        return result;
    }
}
