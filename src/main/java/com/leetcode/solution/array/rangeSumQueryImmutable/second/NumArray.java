package com.leetcode.solution.array.rangeSumQueryImmutable.second;

import com.leetcode.solution.array.rangeSumQueryImmutable.RangeSumQueryImmutableTemplate;

public class NumArray extends RangeSumQueryImmutableTemplate {
    // 问题1：什么类型的数组 => 整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否有序 => 不 care
    // 问题4：如何输出结果 => 返回 int
    // 问题5：函数定义
    // 问题6：检查输入参数
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("The nums is invalid!");
        }

        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    @Override
    public int sumRange(int left, int right) {
        // 思路：数组前缀和 interval[i, j] = prefixSum[j + 1] - prefixSum[i];
        // 时间复杂度：O(1)
        return prefixSum[right + 1] - prefixSum[left];
    }
}
