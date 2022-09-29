package com.leetcode.solution.hashTable.twoSum.third;

import com.leetcode.solution.hashTable.twoSum.TwoSumTemplate;

import java.util.HashMap;
import java.util.Map;

public class TwoSum extends TwoSumTemplate {
    @Override
    public int[] twoSum(int[] nums, int target) {
        // check input
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // map => value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
