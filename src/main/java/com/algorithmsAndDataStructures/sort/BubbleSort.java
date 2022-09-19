package com.algorithmsAndDataStructures.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 9, 4, 7, 2, 0, 8};
        int[] nums1 = new int[]{3, 1, 9, 4, 7, 2, 0, 8};
        new BubbleSort().sort(nums);
        System.out.println("Refine sort");
        new BubbleSort().sortRefine(nums1);

        System.out.println("Sorted");

        int[] numsOfSorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] numsOfSorted1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        new BubbleSort().sort(numsOfSorted);
        System.out.println("Refine sort");
        new BubbleSort().sortRefine(numsOfSorted1);

    }

    public void sort(int[] nums) {
        // 时间复杂度：O(n^2)
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int temp;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }

            System.out.println("The one-time bubble result: " + Arrays.toString(nums));
        }
    }

    public void sortRefine(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int temp;

        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 1; j < length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }

            System.out.println("The one-time bubble result: " + Arrays.toString(nums));
        }
    }
}
