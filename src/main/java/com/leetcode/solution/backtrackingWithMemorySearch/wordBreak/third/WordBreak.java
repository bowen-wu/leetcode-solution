package com.leetcode.solution.backtrackingWithMemorySearch.wordBreak.third;

import com.leetcode.solution.backtrackingWithMemorySearch.wordBreak.WordBreakTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak extends WordBreakTemplate {
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        // Ideas: backtracking + memory search
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        // working with resource data => 1. sort(unique + compare)  2. set(unique + optimize find)  3. Duplicated work
        Set<String> set = new HashSet<>(wordDict);

        // construct memory search => int -> boolean => init -> -1 false -> 0 true -> 1
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, set);
    }

    private boolean helper(int[] memo, String s, int position, Set<String> set) {
        // exit recursion
        if (position >= s.length()) {
            return true;
        }

        // hit cache -> care out of index when memo is array
        if (memo[position] != -1) {
            return memo[position] == 1;
        }

        // construct result => true
        // check [position, s.length() - 1] is result
        String str = s.substring(position);
        if (set.contains(str)) {
            return true;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = s.length() - 1; i >= position; i--) {
            // stage result + pruning
            if (!set.contains(s.substring(position, i + 1))) {
                continue;
            }

            boolean next = helper(memo, s, i + 1, set);
            if (next) {
                memo[position] = 1;
                return true;
            }
        }

        memo[position] = 0;
        return false;
    }
}
