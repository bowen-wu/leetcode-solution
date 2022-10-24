package com.leetcode.solution.doublePointer.wiggleSortII.first;

import com.leetcode.solution.doublePointer.wiggleSortII.WiggleSortTemplate;

import java.util.Arrays;

public class WiggleSort extends WiggleSortTemplate {
    public static void main(String[] args) {
        new WiggleSort().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }

    @Override
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        Arrays.sort(copy);
        int len = nums.length;
        int middleIndex = len % 2 != 0 ? len / 2 : len / 2 - 1;
        int middle = middleIndex;
        int end = len - 1;
        int index = 0;

        while (end > middleIndex) {
            nums[index++] = copy[middle--];
            nums[index++] = copy[end--];
        }
        if (index < len) {
            nums[index] = copy[0];
        }
    }
}
