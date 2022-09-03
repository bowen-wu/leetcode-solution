package com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioning.second;

import com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioning.PartitionTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partition extends PartitionTemplate {
    @Override
    public List<List<String>> partition(String s) {
        // Ideas: backtracking + memory search
        // 1. is need sort => no
        // 2. is need element index => yes
        // 3. helper => List<List<String>> helper(Map<Integer, List<String>> memo, String s, int position)
        // 4. when exit recursion => position >= s.length()
        // 5. when single result add to solution set =>
        // 6. pruning
        //		1. hit cache => return cache
        // 7. recursive decomposition sub problem to next level => for loop => s.length() - 1 -> position
        // 8. how to backtracking =>
        // 9. memory search => 1. isValidPalindrome + 2. split cache
        // check input
        if (s == null || s.length() == 0) {
            return null;
        }

        // working with source data => 1. sort(去重 + 比较大小) 2. set(优化查找) 3. 优化 Duplicate Work
        // 1. isValidPalindrome index i to index j is valid palindrome => range: [i, j]
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);

        // constructor memory search
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return helper(memo, s, 0, isValidPalindrome);
    }

    private List<List<String>> helper(Map<Integer, List<List<String>>> memo, String s, int position, boolean[][] isValidPalindrome) {
        // hit cache => care about out of index if memo is array
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // construct result
        List<List<String>> result = new ArrayList<>();

        // exit recursion
        if (position >= s.length()) {
            return result;
        }

        // is [position, s.length() - 1] result
        if (isValidPalindrome[position][s.length() - 1]) {
            result.add(Collections.singletonList(s.substring(position)));
        }

        for (int i = s.length() - 1; i >= position; i--) {
            if (!isValidPalindrome[position][i]) {
                // pruning
                continue;
            }

            // 阶段性结果 => staged result
            String substring = s.substring(position, i + 1);
            List<List<String>> next = helper(memo, s, i + 1, isValidPalindrome);

            // construct single result
            for (List<String> item : next) {
                List<String> singleResult = new ArrayList<>();
                singleResult.add(substring);
                singleResult.addAll(item);
                result.add(singleResult);
            }
        }

        // update memo
        memo.put(position, result);
        return result;
    }


    private boolean[][] checkIsValidPalindrome(String str) {
        boolean[][] isValidPalindrome = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        for (int i = 1; i < str.length(); i++) {
            isValidPalindrome[i - 1][i] = str.charAt(i - 1) == str.charAt(i);
        }

        // for third and third+ => from str.length() to 0
        for (int i = str.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < str.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && str.charAt(i) == str.charAt(j);
            }
        }

        return isValidPalindrome;
    }
}
