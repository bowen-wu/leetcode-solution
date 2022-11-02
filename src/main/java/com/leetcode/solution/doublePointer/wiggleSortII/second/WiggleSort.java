package com.leetcode.solution.doublePointer.wiggleSortII.second;

import com.leetcode.solution.doublePointer.wiggleSortII.WiggleSortTemplate;

import java.util.Arrays;

public class WiggleSort extends WiggleSortTemplate {
    @Override
    public void wiggleSort(int[] nums) {
        // 时间复杂度: O(nlogn)
        // 空间复杂度: O(n)
        // Ideas: 排序分成两部分，从后往前遍历，第一部分从 middle 开始
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = nums[i];
        }

        int middle = len / 2;
        int first = len % 2 != 0 ? middle : middle - 1;
        int limit = first;
        int second = len - 1;
        int index = 0;
        while (second > limit) {
            nums[index++] = temp[first--];
            nums[index++] = temp[second--];
        }

        if (index < len) {
            nums[index] = temp[0];
        }
    }
}
