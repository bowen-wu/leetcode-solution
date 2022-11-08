package com.leetcode.solution.dynamicProgramming.singleSequence.houseRobber.third;

import com.leetcode.solution.dynamicProgramming.singleSequence.houseRobber.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        // state => f(n) 代表偷窃到第n家时的最高金额
        // status function => f(n) = Math.max(偷窃前一家, 偷窃当前家) = Math.max(f(n - 1), f(n - 2) + nums[n - 1])
        // condition => f(0) = 0 f(1) = nums[0]
        // solution => get f(nums.length)
        //    [1, 2, 3, 1]
        // [0, 1, 2, max(2, 1 + 3)]
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]);
        }

        return memo[len % 2];
    }
}
