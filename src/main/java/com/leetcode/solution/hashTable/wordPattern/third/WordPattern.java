package com.leetcode.solution.hashTable.wordPattern.third;

import com.leetcode.solution.hashTable.wordPattern.WordPatternTemplate;

import java.util.HashMap;
import java.util.Map;

public class WordPattern extends WordPatternTemplate {
    @Override
    public boolean wordPattern(String pattern, String s) {
        // check input
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0) {
            return false;
        }

        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }

        // map => char -> String
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i])) {
                    return false;
                }
            } else if (map.containsValue(strs[i])) {
                return false;
            } else {
                map.put(ch, strs[i]);
            }
        }
        return true;
    }
}
