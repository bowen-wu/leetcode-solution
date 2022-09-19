package com.algorithmsAndDataStructures.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void sort(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partitionTwo(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partitionTwo(int[] nums, int start, int end) {
        int pivot = start;
        int pivotValue = nums[pivot];

        while (start < end) {
            while (start < end && nums[end] >= pivotValue) {
                end--;
            }

            // find the first element that smaller than pivotValue
            nums[start] = nums[end];

            while (start < end && nums[start] <= pivotValue) {
                start++;
            }

            // find the first element that bigger than pivotValue
            nums[end] = nums[start];
        }

        nums[start] = pivotValue;
        return start;
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // j 是第一个小于 pivotValue 的位置
        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;

                // 说明i之前一定有元素大于 pivotValue，需要交换
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, j + 1, end);
        return j + 1;
    }

    private int partitionOfRandom(int[] nums, int start, int end) {
        int i = new Random().nextInt(end) % (end - start + 1) + start;
        swap(nums, i, end);
        return partition(nums, start, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 9, 4, 7, 2, 3, 7, 4, 0, 8};
        new QuickSort().sort(nums);
        System.out.println("The result: " + Arrays.toString(nums));
    }
}
