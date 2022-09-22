package com.leetcode.solution.hashTable.containsDuplicate.first;

import com.leetcode.solution.hashTable.containsDuplicate.ContainsDuplicateTemplate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate extends ContainsDuplicateTemplate {
    @Override
    public boolean containsDuplicate(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
