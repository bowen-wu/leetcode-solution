package com.leetcode.solution.doublePointer.minimumWindowSubstring.third;

import com.leetcode.solution.doublePointer.minimumWindowSubstring.MinWindowTemplate;

import java.util.HashMap;
import java.util.Map;

public class MinWindow extends MinWindowTemplate {
    @Override
    public String minWindow(String s, String t) {
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        int resultLen = Integer.MAX_VALUE;
        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                // 扩展 => map 中的每个值都大于0
                if (expandable(map)) {
                    char ch = s.charAt(j);
                    if (map.containsKey(ch)) {
                        map.merge(ch, -1, Integer::sum);
                    }
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 + update
            if (!expandable(map) && (j - i < resultLen)) {
                resultLen = j - i;
                result = s.substring(i, j);
            }
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }

        return result;
    }


    private boolean expandable(Map<Character, Integer> map) {
        for (int num : map.values()) {
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    public String minWindowWithArray(String s, String t) {
        // check input
        if (s == null || s.length() == 0 || t == null || t.length() > s.length()) {
            return "";
        }

        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)] += 1;
        }

        int resultLen = Integer.MAX_VALUE;
        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                // 扩展 => map 中的每个值都大于0
                if (!allFound(map)) {
                    char ch = s.charAt(j);
                    map[ch] -= 1;
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 + update
            if (allFound(map) && (j - i < resultLen)) {
                resultLen = j - i;
                result = s.substring(i, j);
            }
            map[s.charAt(i)] += 1;
        }

        return result;
    }

    private boolean allFound(int[] map) {
        for (int num : map) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
