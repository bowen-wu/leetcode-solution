package com.leetcode.solution.array.mergeSortedArray.second;

import com.leetcode.solution.array.mergeSortedArray.MergeSortedArrayTemplate;

public class MergeSortedArray extends MergeSortedArrayTemplate {
    // 问题1：什么类型数组 => 整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否有序 => 有
    // 问题4：如何输出结果 => 输出一个有序数组
    // 问题5：函数定义
    // 问题6：检查输入参数
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ((nums1 == null || nums1.length == 0) && nums2 != null) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int[] result = new int[m + n];
        int firstPoint = 0;
        int secondPoint = 0;
        int resultIndex = 0;

        while (firstPoint < m && secondPoint < n) {
            if(nums1[firstPoint] >= nums2[secondPoint]) {
                result[resultIndex++] = nums2[secondPoint++];
            } else {
                result[resultIndex++] = nums1[firstPoint++];
            }
        }

        // 查看剩余元素
        while (firstPoint < m) {
            result[resultIndex++] = nums1[firstPoint++];
        }

        while (secondPoint < n) {
            result[resultIndex++] = nums2[secondPoint++];
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    @Override
    public int[] merge(int[] nums1, int[] nums2) {
        // 思路：双指针。比较两个指针所在位置的大小，小的放进去，之后移动指针，再次比较
        // 两个数组是否有剩余 =>
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(m + n)
        int[] result = new int[nums1.length + nums2.length];
        int firstPoint = 0;
        int secondPoint = 0;
        int resultIndex = 0;

        while (firstPoint < nums1.length && secondPoint < nums2.length) {
            if(nums1[firstPoint] >= nums2[secondPoint]) {
                result[resultIndex++] = nums2[secondPoint++];
            } else {
                result[resultIndex++] = nums1[firstPoint++];
            }
        }

        // 查看剩余元素
        while (firstPoint < nums1.length) {
            result[resultIndex++] = nums1[firstPoint++];
        }

        while (secondPoint < nums2.length) {
            result[resultIndex++] = nums2[secondPoint++];
        }

        return result;
    }
}
