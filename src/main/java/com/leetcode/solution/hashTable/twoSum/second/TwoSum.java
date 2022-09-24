package com.leetcode.solution.hashTable.twoSum.second;


import com.leetcode.solution.hashTable.twoSum.TwoSumTemplate;

import java.util.HashMap;
import java.util.Map;

public class TwoSum extends TwoSumTemplate {
    @Override
    public int[] twoSum(int[] nums, int target) {
        // Ideas: hash table
        // check input
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // map => remaining value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
