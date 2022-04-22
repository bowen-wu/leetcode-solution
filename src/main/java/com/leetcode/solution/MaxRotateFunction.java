package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/rotate-function/
 * 396. 旋转函数
 */
public class MaxRotateFunction {
    public static void main(String[] args) {
        System.out.println(new MaxRotateFunction().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int maxRotateFunction(int[] nums) {
        // sum 为数组和
        // a(1) 为数组第一项
        // F(n) = F(n - 1) + sum - L * a(L - n);
        int length = nums.length;
        int sum = 0;
        int fCurrent = 0;

        // O(n)
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            fCurrent += i * nums[i];
        }
        int result = fCurrent;

        // O(n - 1)
        for (int i = 1; i < length; i++) {
            fCurrent += sum - length * nums[length - i];
            result = Math.max(result, fCurrent);
        }

        return result;
    }
}
