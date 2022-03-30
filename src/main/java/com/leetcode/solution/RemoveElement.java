package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 27. 移除元素
 * 双指针 => 快慢指针 | 左右指针
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        return currentIndex;
    }
}
