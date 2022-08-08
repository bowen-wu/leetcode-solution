package com.leetcode.solution.stackAndQueue.nextGreaterNumber;

/**
 * Next Greater Number问题
 * 给定一个整型数组nums，要求打印出所有元素右边第一个大于该元素的值。
 * Case 1: 数组nums=[1,5,3,6,4,8,9,10] 输出[5, 6, 6, 8, 8, 9, 10, -1]
 * Case 2: 数组nums=[8, 2, 5, 4, 3, 9, 7, 2, 5] 输出[9, 5, 9, 9, 9, -1, -1, 5, -1]
 */
abstract public class NextGreaterNumberTemplate {
    // 1, 5, 3, 6, 4, 8, 9, 10
    abstract public int[] findRightNextGreater(int[] nums); // 5, 6, 6, 8, 8, 9, 10, -1

    abstract public int[] findLeftNextGreater(int[] nums); // -1, -1, 5, -1, 6, -1, -1, -1

    abstract public int[] findRightNextSmaller(int[] nums); // -1, 3, -1, 4, -1, -1, -1, -1

    abstract public int[] findLeftNextSmaller(int[] nums); // -1, 1, 1, 3, 3, 4, 8, 9
}
