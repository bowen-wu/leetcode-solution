package com.leetcode.solution.backtrackingWithMemorySearch.wordBreak.second;

import com.leetcode.solution.backtrackingWithMemorySearch.wordBreak.WordBreakTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak extends WordBreakTemplate {
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        // Ideas: backtracking + memory search
        // 1. is need sort => no
        // 2. is need element index => yes
        // 3. helper => boolean helper(boolean[] memo, String s, int position, Set<String> set)
        // 4. when exit recursion => position >= s.length()
        // 5. when single result add solution set => no
        // 6. pruning
        // 		1. hit cache
        // 7. recursive decomposition sub problem to next level => for loop => s.length() -> position
        // 8. how to backtracking => no
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        // work with resource data -> 1. sort(重复 + 大小问题) 2. Set(优化查找) 3. Duplicate Work
        Set<String> set = new HashSet<>(wordDict);

        // construct memory search => -1: init 0: false 1: true
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, 0, set);
    }

    private boolean helper(int[] memo, String s, int position, Set<String> set) {
        // exit recursion
        if (position >= s.length()) {
            return true;
        }

        // hit cache => check out of index if memory search is array
        if (memo[position] != -1) {
            return memo[position] == 1;
        }

        // recursive decomposition sub problem to next level
        for (int i = s.length() - 1; i >= position; i--) {
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                // pruning
                continue;
            }

            boolean next = helper(memo, s, i + 1, set);
            if (next) {
                // update memo
                memo[position] = 1;
                return true;
            }
        }

        // update memo
        memo[position] = 0;
        return false;
    }
}
