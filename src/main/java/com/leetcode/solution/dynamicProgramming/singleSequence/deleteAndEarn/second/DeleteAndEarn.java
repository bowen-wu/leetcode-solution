package com.leetcode.solution.dynamicProgramming.singleSequence.deleteAndEarn.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.deleteAndEarn.DeleteAndEarnTemplate;

public class DeleteAndEarn extends DeleteAndEarnTemplate {
    @Override
    public int deleteAndEarn(int[] nums) {
        // 转化问题 => case: [2, 2, 3, 3, 3, 4]
        //  1. 找最大值 => O(n) => 4
        //  2. 创建数组 => [0, 0, 0, 0, 0]
        //  3. 遍历 => [0, 0, 4, 9, 4]
        //  4. 打家劫舍
        // state => f(n) 表示偷窃到第n家偷窃总额
        // status function => f(n) = Math.max(偷窃第n-1家, 偷窃第n家) = Math.max(f(n - 1), nums[n - 1] + f(n - 2))
        // condition => f(0) = 0 f(1) = nums[0]
        // solution => 求 f(n)
        // case: [1, 2, 3, 3]
        //    [0, 1, max(2, 1)]
        //    [0, 1, 2, max(2, 3 + 1)]
        //    [0, 1, 2, 4, max(4, 3 + 2)]
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] earn = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            earn[nums[i]] += nums[i];
        }

        int result = 0;
        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = earn[0];
        for (int i = 2; i <= earn.length; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], earn[i - 1] + memo[(i - 2) % 2]);
        }

        return memo[earn.length % 2];
    }
}
