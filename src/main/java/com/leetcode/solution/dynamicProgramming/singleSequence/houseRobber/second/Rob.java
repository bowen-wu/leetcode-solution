package com.leetcode.solution.dynamicProgramming.singleSequence.houseRobber.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.houseRobber.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        // state => f(n) 表示偷窃到第n家时的偷窃总额
        // status function => f(n) = Math.max(偷第n - 1家, 不偷第n - 1家(偷第n家)) = Math.max(nums[n - 1] + f(n - 2), f(n - 1))
        // condition => x
        // solution => 求 f(nums.length)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // case: [1, 2, 3, 1]
        //    [0, 1, max(1, 2)]
        //    [0, 1, 2, max(2, 3 + 1)]
        //    [0, 1, 2, 4, max(4, 1 + 2)]
        // memo 比 nums 多了一个元素
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            memo[i % 2] = Math.max(nums[i - 1] + memo[(i - 2) % 2], memo[(i - 1) % 2]);
        }
        return memo[nums.length % 2];
    }
}
