package com.leetcode.solution.array.mergeSortedArray.first;

import com.leetcode.solution.array.mergeSortedArray.MergeSortedArrayTemplate;

public class MergeSortedArray extends MergeSortedArrayTemplate {
    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    public void mergeForPlace(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int startIndex = m - 1;
        int endIndex = n - 1;
        int placeIndex = m + n - 1;
        while (startIndex >= 0 && endIndex >= 0) {
            if (nums1[startIndex] <= nums2[endIndex]) {
                nums1[placeIndex] = nums2[endIndex];
                endIndex--;
            } else {
                nums1[placeIndex] = nums1[startIndex];
                startIndex--;
            }
            placeIndex--;
        }

        // nums1 is empty or not?
        while (startIndex < m && startIndex >= 0) {
            nums1[placeIndex--] = nums1[startIndex--];
        }

        // nums2 is empty or not?
        while (endIndex < n && endIndex >= 0) {
            nums1[placeIndex--] = nums2[endIndex--];
        }
    }

    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(m + n)
        if ((nums1 == null || m == 0) && nums2 != null) {
            for (int i = 0; i < n; i++) {
                assert nums1 != null;
                nums1[i] = nums2[i];
            }
            return;
        }
        if (nums2 == null || n == 0) {
            return;
        }

        int[] result = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                result[index++] = nums1[index1++];
            } else {
                result[index++] = nums2[index2++];
            }
        }

        // nums1 is empty or not?
        while (index1 < m) {
            result[index++] = nums1[index1++];
        }

        // nums2 is empty or not?
        while (index2 < n) {
            result[index++] = nums2[index2++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }

    @Override
    public int[] merge(int[] nums1, int[] nums2) {
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(m + n)
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }

        int[] result = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                result[index++] = nums1[index1++];
            } else {
                result[index++] = nums2[index2++];
            }
        }

        // nums1 is empty or not?
        while (index1 < nums1.length) {
            result[index++] = nums1[index1++];
        }

        // nums2 is empty or not?
        while (index2 < nums2.length) {
            result[index++] = nums2[index2++];
        }

        return result;
    }
}
