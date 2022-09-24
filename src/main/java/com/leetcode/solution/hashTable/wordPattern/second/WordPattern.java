package com.leetcode.solution.hashTable.wordPattern.second;

import com.leetcode.solution.hashTable.wordPattern.WordPatternTemplate;

import java.util.HashMap;
import java.util.Map;

public class WordPattern extends WordPatternTemplate {
    @Override
    public boolean wordPattern(String pattern, String s) {
        // Ideas: Hash table
        // check input
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0) {
            return true;
        }

        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }

        // map => char -> String
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strings[i])) {
                    return false;
                }
            } else if (map.containsValue(strings[i])) {
                return false;
            } else {
                map.put(ch, strings[i]);
            }
        }

        return true;
    }
}
