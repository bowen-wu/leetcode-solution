package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 908. 最小差值 I
 */
public class SmallestRangeI {
    public static void main(String[] args) {
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{9}, 2)); // 7 7 7 => 0
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{1, 5, 9}, 2)); // 3 3 7 => 4
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        return max - min >= 2 * k ? max- min - 2 * k : 0;
    }
}
