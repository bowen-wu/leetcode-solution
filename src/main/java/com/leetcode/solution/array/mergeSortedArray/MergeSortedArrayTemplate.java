package com.leetcode.solution.array.mergeSortedArray;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 * 88. 合并两个有序数组
 * 给定两个有序整数数组nums1和nums2，请按递增顺序将它们合并到一个排序数组中
 * <p>
 * 例：
 * Input: {1, 3, 5}, {2, 4, 6}
 * Output: {1, 2, 3, 4, 5, 6}
 */
abstract public class MergeSortedArrayTemplate {
    abstract public void merge(int[] nums1, int m, int[] nums2, int n);

    abstract public int[] merge(int[] nums1, int[] nums2);
}
