package com.leetcode.solution.backtrackingWithMemorySearch.wordBreakII.second;

import com.leetcode.solution.backtrackingWithMemorySearch.wordBreakII.WordBreakTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak extends WordBreakTemplate {
    @Override
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Ideas: backtracking + memory search
        // 1. is need sort => no
        // 2. is need element index => yes
        // 3. helper => List<String> helper(Map<Integer, List<String>> memo, String s, int position, Set<String> set)
        // 4. when exit recursion => position >= s.length()
        // 5. when single result add to solution set => no
        // 6. pruning => hit cache
        // 7. recursive decomposition sub problem to next level => for loop => s.length() - 1 -> position
        // 8. how to backtracking
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }

        // working with resource data => 1. Sort(重复 + 比较大小) 2. Set(优化查找) 3. Duplicate Word
        Set<String> set = new HashSet<>(wordDict);

        // construct memory search
        Map<Integer, List<String>> memo = new HashMap<>();
        return helper(memo, s, 0, set);
    }

    private List<String> helper(Map<Integer, List<String>> memo, String s, int position, Set<String> set) {
        // hit cache => care out of index if memo is array
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // construct result
        List<String> result = new ArrayList<>();

        // exit recursion
        if (position >= s.length()) {
            return result;
        }

        // check [position, s.length() - 1] is result
        String str = s.substring(position);
        if (set.contains(str)) {
            result.add(str);
        }

        // recursive decomposition sub problem to next level
        for (int i = s.length() - 1; i >= position; i--) {
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                // pruning
                continue;
            }

            List<String> next = helper(memo, s, i + 1, set);

            // construct single result and add to result
            for (String item : next) {
                result.add(substring + " " + item);
            }
        }

        // update memo
        memo.put(position, result);
        return result;
    }
}
