package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 * 905. 按奇偶排序数组
 */
public class SortArrayByParity {
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 原地排序
    public int[] sortArrayByParity(int[] nums) {
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        while (rightPoint > leftPoint) {
            int leftValue = nums[leftPoint];
            int rightValue = nums[rightPoint];
            if (leftValue % 2 == 0) {
                // 左指针是偶数
                leftPoint++;
            } else if (rightValue % 2 == 0) {
                // 左指针是奇数 & 右指针是偶数
                nums[leftPoint] = rightValue;
                nums[rightPoint] = leftValue;
                leftPoint++;
                rightPoint--;
            } else {
                // 左指针是奇数 & 右指针是奇数
                rightPoint--;
            }
        }
        return nums;
    }
}
