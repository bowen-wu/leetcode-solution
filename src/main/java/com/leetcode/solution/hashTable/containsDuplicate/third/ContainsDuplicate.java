package com.leetcode.solution.hashTable.containsDuplicate.third;

import com.leetcode.solution.hashTable.containsDuplicate.ContainsDuplicateTemplate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate extends ContainsDuplicateTemplate {
    @Override
    public boolean containsDuplicate(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return true;
        }

        // map => value
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
