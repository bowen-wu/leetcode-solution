package com.leetcode.solution.stackAndQueue.nextGreaterElementI.first;

import com.leetcode.solution.stackAndQueue.nextGreaterElementI.NextGreaterElementTemplate;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElement extends NextGreaterElementTemplate {
    @Override
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        // key: 元素本身 value：右侧比它大的第一个元素
        Map<Integer, Integer> nums2GreaterMap = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        // 右侧 => 从左向右
        for (int i = 0; i < nums2.length; i++) {
            // Greater => 栈底到栈顶单调递减
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nums2GreaterMap.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            if (nums2GreaterMap.containsKey(nums1[i])) {
                result[i] = nums2GreaterMap.get(nums1[i]);
            }
        }

        return result;
    }
}
