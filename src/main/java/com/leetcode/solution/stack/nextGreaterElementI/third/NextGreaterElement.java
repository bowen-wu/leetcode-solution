package com.leetcode.solution.stack.nextGreaterElementI.third;

import com.leetcode.solution.stack.nextGreaterElementI.NextGreaterElementTemplate;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement extends NextGreaterElementTemplate {
    @Override
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 思路：使用栈底到栈顶单调递减栈。对 nums2 做 Next Greater Number，之后遍历 nums1，在 nums2 中找到下标
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }


        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextGreater.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            if (nextGreater.get(nums1[i]) != null) {
                result[i] = nextGreater.get(nums1[i]);
            }
        }

        return result;
    }
}
