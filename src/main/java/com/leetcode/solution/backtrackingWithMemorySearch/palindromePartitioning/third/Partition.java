package com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioning.third;

import com.leetcode.solution.backtrackingWithMemorySearch.palindromePartitioning.PartitionTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partition extends PartitionTemplate {
    @Override
    public List<List<String>> partition(String s) {
        // Ideas: backtracking + memory search => 1. isValidPalindrome[][] [i, j] isValidPalindrome   2. Map<Integer, List<List<String>>> => index -> List<List<String>>
        // is need working with resource data => yes
        // is need element position index => yes
        // helper => List<List<String>> helper(Map<Integer, List<List<String>>>, String s, int position, boolean isValidPalindrome)
        // when exit recursion => 1. hit cache  2. position >= s.length()
        // single result add to solution set =>
        // pruning => 1. isValidPalindrome[postion][s.length() - 1] => single result
        // recusive decomposition sub problem to next level => for loop
        // how to backtrack => single result delete last element
        // check input
        if (s == null || s.length() == 0) {
            return null;
        }

        // working with resource data => 1. sort(unique + compare) 2. set(unique + optimize find) 3. Duplicated work
        boolean[][] isValidPalindrome = checkIsValidPalindrome(s);

        // memory search
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        return helper(memo, s, 0, isValidPalindrome);
    }

    private List<List<String>> helper(Map<Integer, List<List<String>>> memo, String s, int position, boolean[][] isValidPalindrome) {
        // hit cache => care out of index when cache is array
        if (memo.containsKey(position)) {
            return memo.get(position);
        }

        // construct result
        List<List<String>> result = new ArrayList<>();

        // exit recursion
        if (position >= s.length()) {
            return result;
        }

        // check [position, s.length() - 1] is result
        if (isValidPalindrome[position][s.length() - 1]) {
            result.add(Arrays.asList(s.substring(position)));
        }

        // recursion decomposition sub problem to next level + pruning
        for (int i = s.length() - 1; i >= position; i--) {
            // pruning
            if (!isValidPalindrome[position][i]) {
                continue;
            }

            List<List<String>> next = helper(memo, s, i + 1, isValidPalindrome);
            String substring = s.substring(position, i + 1);

            // construct single result
            for (List<String> item : next) {
                List<String> singleResult = new ArrayList<>();
                singleResult.add(substring);
                singleResult.addAll(item);
                result.add(singleResult);
            }
        }

        // update memory search
        memo.put(position, result);
        return result;
    }

    private boolean[][] checkIsValidPalindrome(String s) {
        boolean[][] isValidPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isValidPalindrome[i][i] = true;
        }

        for (int i = 1; i < s.length(); i++) {
            isValidPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }

        // third + third+ => length -> 0
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isValidPalindrome[i][j] = isValidPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        return isValidPalindrome;
    }
}
