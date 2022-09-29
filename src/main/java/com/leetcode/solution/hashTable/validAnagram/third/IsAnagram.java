package com.leetcode.solution.hashTable.validAnagram.third;

import com.leetcode.solution.hashTable.validAnagram.IsAnagramTemplate;

import java.util.Arrays;

public class IsAnagram extends IsAnagramTemplate {
    @Override
    public boolean isAnagram(String s, String t) {
        // Ideas: 出现次数
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        // map => Character -> int
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int newNum = map[t.charAt(i) - 'a'] - 1;
            if (newNum < 0) {
                return false;
            }
            map[t.charAt(i) - 'a'] = newNum;
        }
        return true;
    }

    public boolean isAnagramWithOrder(String s, String t) {
        // Ideas: 字母序
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length()) {
            return false;
        }

        return getOrder(s).equals(getOrder(t));
    }

    private String getOrder(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
