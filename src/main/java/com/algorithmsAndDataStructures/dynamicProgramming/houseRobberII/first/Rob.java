package com.algorithmsAndDataStructures.dynamicProgramming.houseRobberII.first;

import com.algorithmsAndDataStructures.dynamicProgramming.houseRobber.RobTemplate;

public class Rob extends RobTemplate {
    @Override
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // memo[i] 代表偷窃到第 i 家的金额
        // 偷窃第一家
        int len = nums.length;
        int[] memo = new int[2];
        memo[1] = nums[0];
        for (int i = 2; i < len; i++) {
//        for (int i = 2; i <= len; i++) {
//            if (i == len) {
//                memo[i % 2] = memo[(i - 1) % 2];
//                continue;
//            }
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]);
        }

        // len 可能小于2，此时 len % 2 就是初始值
        int currentResult = len > 2 ? memo[(len - 1) % 2] : memo[len % 2];

        // 偷窃第二家
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= len; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + nums[i - 1]);
        }
        return Math.max(currentResult, memo[len % 2]);
    }
}
