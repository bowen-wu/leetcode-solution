package com.leetcode.solution.hashTable.validAnagram.second;

import com.leetcode.solution.hashTable.validAnagram.IsAnagramTemplate;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram extends IsAnagramTemplate {
    @Override
    public boolean isAnagram(String s, String t) {
        // Ideas: 1. 字母序 equals 2. 出现次数相同
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => char -> value => char - 'a' => int -> value
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map[ch - 'a'] == 0) {
                return false;
            } else {
                map[ch - 'a'] -= 1;
            }
        }

        return true;
    }

    public boolean isAnagramWithHashMap(String s, String t) {
        // Ideas: 1. 字母序 equals 2. 出现次数相同
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => char -> value
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
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

        return map.isEmpty();
    }
}
