package com.leetcode.solution.hashTable.isomorphicStrings.first;

import com.leetcode.solution.hashTable.isomorphicStrings.IsIsomorphicTemplate;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic extends IsIsomorphicTemplate {
    @Override
    public boolean isIsomorphic(String s, String t) {
        // check input
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // map => s -> t
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else if (map.containsValue(tChar)) {
                return false;
            } else {
                map.put(sChar, tChar);
            }
        }
        return true;
    }


    public boolean isIsomorphicTwoMap(String s, String t) {
        // check input
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // map => s -> t
        Map<Character, Character> map1 = new HashMap<>();

        // map => t -> s
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map1.containsKey(sChar)) {
                if (map1.get(sChar) != tChar) {
                    return false;
                }
            } else if (map2.containsKey(tChar)) {
                if (map2.get(tChar) != sChar) {
                    return false;
                }
            } else {
                map1.put(sChar, tChar);
                map2.put(tChar, sChar);
            }
        }
        return true;
    }
}
