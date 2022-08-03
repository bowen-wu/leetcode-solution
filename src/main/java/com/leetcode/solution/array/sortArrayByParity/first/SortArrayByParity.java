package com.leetcode.solution.array.sortArrayByParity.first;

import com.leetcode.solution.array.sortArrayByParity.SortArrayByParityTemplate;

import java.util.Arrays;

public class SortArrayByParity extends SortArrayByParityTemplate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{3, 2, 1, 4})));
    }

    public int[] sortArrayByParity(int[] nums) {
        // 双指针
        // leftPoint 第一个奇数
        // rightPoint 第一个偶数
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        while (leftPoint < rightPoint) {
            if (nums[leftPoint] % 2 != 0 && nums[rightPoint] % 2 == 0) {
                swap(nums, leftPoint, rightPoint);
                leftPoint++;
                rightPoint--;
            }
            if (nums[leftPoint] % 2 == 0) {
                leftPoint++;
            }
            if (nums[rightPoint] % 2 != 0) {
                rightPoint--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }
}
