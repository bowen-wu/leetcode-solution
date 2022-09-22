package com.leetcode.solution.hashTable.validAnagram.first;

import com.leetcode.solution.hashTable.validAnagram.IsAnagramTemplate;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram extends IsAnagramTemplate {
    @Override
    public boolean isAnagram(String s, String t) {
        // check input
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // map => ch -> int
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                int newNum = map.get(ch) - 1;
                if (newNum == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, newNum);
                }
            } else {
                return false;
            }
        }

        return map.size() == 0;
    }

    public boolean isAnagramWithArray(String s, String t) {
        // check input
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // map => ch -> int
        int[] visited = new int[26];

        for (int i = 0; i < s.length(); i++) {
            visited[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            visited[t.charAt(i) - 'a'] -= 1;
            if (visited[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

//        for (int num : visited) {
//            if (num != 0) {
//                return false;
//            }
//        }

        return true;
    }
}
