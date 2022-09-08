package com.leetcode.solution.backtrackingWithMemorySearch.wordBreakII.third;

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
        // check input
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return null;
        }

        // working with resource data => 1. sort(unique + compare)  2. set(unique + optimize find)  3. Duplicated work
        Set<String> set = new HashSet<>(wordDict);

        // construct memory search => int -> List<String>
        Map<Integer, List<String>> memo = new HashMap<>();
        return helper(memo, s, 0, set);
    }

    private List<String> helper(Map<Integer, List<String>> memo, String s, int position, Set<String> set) {
        // hit cache => care out of index when memo is array
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

        // recursive decomposition sub problem to next level + pruning
        for (int i = s.length() - 1; i >= position; i--) {
            // stage result
            String substring = s.substring(position, i + 1);
            if (!set.contains(substring)) {
                // pruning
                continue;
            }

            List<String> next = helper(memo, s, i + 1, set);

            // construct single result
            for (String item : next) {
                result.add(substring + " " + item);
            }
        }

        // update memory search
        memo.put(position, result);
        return result;
    }
}
