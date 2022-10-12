package com.algorithmsAndDataStructures.dynamicProgramming.deleteAndEarn.first;

import com.algorithmsAndDataStructures.dynamicProgramming.deleteAndEarn.DeleteAndEarnTemplate;

public class DeleteAndEarn extends DeleteAndEarnTemplate {
    @Override
    public int deleteAndEarn(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 找到最大值，确定 values 数组长度
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] values = new int[max + 1];
        for (int num : nums) {
            values[num] += num;
        }

        // 打家劫舍问题
        // State => memo[i] 偷窃到第 i 家的金额
        // Function => memo[i] = Math.max(memo[i - 1], memo[i - 2] + values[i])
        // Condition => 1. memo[0] = 0; 2. memo[1] = values[1]
        int[] memo = new int[2];
        memo[1] = values[1];
        for (int i = 2; i < values.length; i++) {
            memo[i % 2] = Math.max(memo[(i - 1) % 2], memo[(i - 2) % 2] + values[i]);
        }
        return memo[(values.length - 1) % 2];
    }
}
