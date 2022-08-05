package com.leetcode.solution.array.runningSum.second;

import com.leetcode.solution.array.runningSum.RunningSumTemplate;

public class RunningSum extends RunningSumTemplate {
    // 问题1：什么类型的数组 => 数组
    // 问题2：是否有重复元素 => 不 care
    // 问题3：是否有序 => 不 care
    // 问题4：如何输出 => 返回 int 数组
    // 问题5：函数定义
    // 问题6：检查输入参数
    @Override
    public int[] runningSum(int[] nums) {
        // 思路：数组前缀和
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
