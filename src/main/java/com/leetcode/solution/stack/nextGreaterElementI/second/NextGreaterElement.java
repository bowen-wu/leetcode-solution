package com.leetcode.solution.stack.nextGreaterElementI.second;

import com.leetcode.solution.stack.nextGreaterElementI.NextGreaterElementTemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement extends NextGreaterElementTemplate {
    // 思路：对 num2 做栈底到栈顶的单调递减栈，拿到 nums2 的右侧第一个最大值
    //      之后循环 nums1，在 nums2 中确定 index，在右侧第一个最大值数组中找到该值。O(n^2) + O(n)
    @Override
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return null;
        }

        int[] nextGreater = new int[nums2.length];
        Arrays.fill(nextGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextGreater[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nextGreater[j];
                    break;
                }
            }
        }

        return result;
    }
}
