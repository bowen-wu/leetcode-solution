package com.leetcode.solution.array.mergeSortedArray.third;

import com.leetcode.solution.array.mergeSortedArray.MergeSortedArrayTemplate;

public class MergeSortedArray extends MergeSortedArrayTemplate {
    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    @Override
    public int[] merge(int[] nums1, int[] nums2) {
        // 思路
        // 双指针 => firstPointer + secondPointer，初始值为0，比较两者，较小的放入 result 中，之后移动较小的指针，继续比较。O(m + n)
        // 需要使用 while 循环，还要处理剩余元素
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }

        int[] result = new int[nums1.length + nums2.length];
        int index = 0;
        int first = 0;
        int second = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] > nums2[second]) {
                result[index++] = nums2[second++];
            } else {
                result[index++] = nums1[first++];
            }
        }

        while (first < nums1.length) {
            result[index++] = nums1[first++];
        }

        while (second < nums2.length) {
            result[index++] = nums2[second++];
        }

        return result;
    }
}
