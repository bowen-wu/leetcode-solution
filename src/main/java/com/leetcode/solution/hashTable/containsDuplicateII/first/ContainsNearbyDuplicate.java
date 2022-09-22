package com.leetcode.solution.hashTable.containsDuplicateII.first;

import com.leetcode.solution.hashTable.containsDuplicateII.ContainsNearbyDuplicateTemplate;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate extends ContainsNearbyDuplicateTemplate {
    @Override
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // check input
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }

        // map => value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
