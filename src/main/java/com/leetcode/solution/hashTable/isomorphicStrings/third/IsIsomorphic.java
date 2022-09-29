package com.leetcode.solution.hashTable.isomorphicStrings.third;

import com.leetcode.solution.hashTable.isomorphicStrings.IsIsomorphicTemplate;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic extends IsIsomorphicTemplate {
    @Override
    public boolean isIsomorphic(String s, String t) {
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => character -> character
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (map.containsKey(first)) {
                // contains
                if (map.get(first) != second) {
                    return false;
                }
            } else if (map.containsValue(second)) {
                return false;
            } else {
                map.put(first, second);
            }
        }
        return true;
    }
}
