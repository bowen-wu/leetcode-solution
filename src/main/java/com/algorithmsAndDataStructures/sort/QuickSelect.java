package com.algorithmsAndDataStructures.sort;

public class QuickSelect {
    public int getKthSmallerElement(int[] nums, int k) {
        // check input
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivot = partition(nums, start, end);
        if (pivot == k - 1) {
            return nums[pivot];
        }
        if (pivot < k - 1) {
            // 高区
            return quickSelect(nums, pivot + 1, end, k);
        }

        // 低区
        return quickSelect(nums, start, pivot - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];
        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;

                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }

        swap(nums, j + 1, end);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 9, 4, 7, 2, 3, 7, 4, 0, 8}; // [0, 1, 2, 3, 3, 4, 4, 7, 7, 8, 9]

        System.out.println(new QuickSelect().getKthSmallerElement(nums, 1));
        System.out.println(new QuickSelect().getKthSmallerElement(nums, 3));
        System.out.println(new QuickSelect().getKthSmallerElement(nums, 5));
        System.out.println(new QuickSelect().getKthSmallerElement(nums, 7));
        System.out.println(new QuickSelect().getKthSmallerElement(nums, 9));
        System.out.println(new QuickSelect().getKthSmallerElement(nums, 10));
    }
}
