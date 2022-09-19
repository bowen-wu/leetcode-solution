package com.algorithmsAndDataStructures.sort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            mergeTwoSortedArray(nums, start, mid, end);
        }
    }

    private void mergeTwoSortedArray(int[] nums, int start, int mid, int end) {
        // copy arrays
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i + start];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = nums[i + mid + 1];
        }

        // merge two sorted array
        int index = start;
        int first = 0;
        int second = 0;

        while (first < left.length && second < right.length) {
            if (left[first] < right[second]) {
                nums[index++] = left[first++];
            } else {
                nums[index++] = right[second++];
            }
        }

        // remaining
        while (first < left.length) {
            nums[index++] = left[first++];
        }

        while (second < right.length) {
            nums[index++] = right[second++];
        }
    }

    public void sortTwo(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);
        mergeTwoSortedArray(nums, temp, start, mid, end);
    }

    private void mergeTwoSortedArray(int[] nums, int[] temp, int start, int mid, int end) {
        // merge two sorted array
        int index = start;
        int first = start;
        int second = mid + 1;

        while (first <= mid && second <= end) {
            if (nums[first] < nums[second]) {
                temp[index++] = nums[first++];
            } else {
                temp[index++] = nums[second++];
            }
        }

        // remaining
        while (first <= mid) {
            temp[index++] = nums[first++];
        }
        while (second <= end) {
            temp[index++] = nums[second++];
        }

        // copy
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 9, 4, 7, 2, 3, 7, 4, 0, 8}; // [0, 1, 2, 3, 3, 4, 4, 7, 7, 8, 9]
        new MergeSort().sortTwo(nums);
        System.out.println("The result: " + Arrays.toString(nums));
    }
}
