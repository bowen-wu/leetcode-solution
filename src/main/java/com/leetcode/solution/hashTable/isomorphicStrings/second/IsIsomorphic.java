package com.leetcode.solution.hashTable.isomorphicStrings.second;

import com.leetcode.solution.hashTable.isomorphicStrings.IsIsomorphicTemplate;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic extends IsIsomorphicTemplate {
    @Override
    public boolean isIsomorphic(String s, String t) {
        // Ideas: Hash table
        // check input
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => a -> b
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (map.containsKey(first)) {
                if (map.get(first) != second) {
                    return false;
                }
            } else if (map.containsValue(second)) {
                // 此处是 O(n) 的，可以使用另外的 map 替代
                return false;
            } else {
                map.put(first, second);
            }
        }
        return true;
    }
}
