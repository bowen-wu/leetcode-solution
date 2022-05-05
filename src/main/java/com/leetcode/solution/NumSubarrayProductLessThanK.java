package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 713. 乘积小于 K 的子数组
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK1(new int[]{1, 4, 2, 4, 10, 5, 2, 6}, 1));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int leftIndex = 0;
        int result = 0;
        int accumulate = 1;
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (currentValue < k) {
                if (leftIndex == -1) {
                    leftIndex = i;
                }
                accumulate *= currentValue;
                while (accumulate >= k) {
                    accumulate = accumulate / nums[leftIndex];
                    leftIndex++;
                }
                result += (i - leftIndex + 1);
            } else {
                leftIndex = -1;
                accumulate = 1;
            }
        }
        return result;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) return 0;
        int result = 0;
        for (int i = 0, leftIndex = 0, accumulate = 1; i < nums.length; i++) {
            accumulate *= nums[i];
            while (accumulate >= k) {
                accumulate = accumulate / nums[leftIndex++];
            }
            result += (i - leftIndex + 1);
        }
        return result;
    }
}
