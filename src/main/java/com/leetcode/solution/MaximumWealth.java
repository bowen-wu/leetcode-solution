package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/richest-customer-wealth/submissions/
 * 1672. 最富有客户的资产总量
 */
public class MaximumWealth {
    public static void main(String[] args) {
        System.out.println(new MaximumWealth().maximumWealth(new int[][]{new int[]{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }

    // m * n 的二位数组
    // 时间复杂度：O(m * n)
    // 空间复杂度：O(1)
    public int maximumWealth(int[][] accounts) {
        int result = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int currentWealth = 0;
            for (int i : account) {
                currentWealth += i;
            }
            result = Math.max(result, currentWealth);
        }
        return result;
    }
}
