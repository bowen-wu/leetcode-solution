package com.leetcode.solution;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * 462. 最少移动次数使数组元素相等 II
 */
public class MinMoves2 {
    public static void main(String[] args) {
        System.out.println(new MinMoves2().minMoves2(new int[]{203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143}));
    }

    // 中位数 => 官方答案
    // 时间复杂度：O(n * logn)，其中 n 是数组 nums 的长度。排序需要 O(n * logn) 的时间
    // 空间复杂度：O(logn)。排序需要 O(logn) 的递归栈空间
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int median = nums[(nums.length - 1) / 2];
        for (int num : nums) {
            result += Math.abs(num - median);
        }
        return result;
    }
}
