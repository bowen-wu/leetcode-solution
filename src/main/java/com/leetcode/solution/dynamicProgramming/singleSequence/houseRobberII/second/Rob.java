package com.leetcode.solution.dynamicProgramming.singleSequence.houseRobberII.second;

import com.leetcode.solution.dynamicProgramming.singleSequence.houseRobberII.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        // state => f(n) 表示偷窃到第n家时的偷窃总额
        // status function => f(n) = Math.max(偷窃到前一家的总额, 偷窃第n家 + 偷窃到第 n - 2 家的总额) = Math.max(偷n - 1家, 偷第n家(不能偷第一家))
        // 如果是奇数，则偷窃到最后一家时 - nums[0]
        // condition => f(0) = 0 f(1) = nums[0]
        // solution => 求 f(nums.length)
        // 思路：偷第一家 或者 偷第二家
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        // 偷第一家 => 不偷最后一家
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i < len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], nums[i - 1] + memo[(i - 2) % 2]);
        }
        int result = memo[(len - 1) % 2];


        // 偷第二家
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], nums[i - 1] + memo[(i - 2) % 2]);
        }

        return Math.max(result, memo[len % 2]);
    }
}
