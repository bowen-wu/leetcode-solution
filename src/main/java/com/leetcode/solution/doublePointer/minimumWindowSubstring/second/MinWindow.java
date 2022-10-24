package com.leetcode.solution.doublePointer.minimumWindowSubstring.second;

import com.leetcode.solution.doublePointer.minimumWindowSubstring.MinWindowTemplate;

import java.util.HashMap;
import java.util.Map;

public class MinWindow extends MinWindowTemplate {
    @Override
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)] += 1;
        }

        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!allFound(map)) {
                    char ch = s.charAt(j);
                    map[ch] -= 1;
                    j++;
                } else {
                    break;
                }
            }

            // 收窄
            if (allFound(map) && (result == "" || (j - i < result.length()))) {
                result = s.substring(i, j);
            }
            map[s.charAt(i)] += 1;
        }
        return result;
    }

    private boolean allFound(int[] map) {
        for (int j : map) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }

    public String minWindowWithMap(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (has(map)) {
                    if (map.containsKey(ch)) {
                        map.merge(ch, -1, Integer::sum);
                    }
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 => 全部找到
            if (!has(map) && (result == "" || (j - i < result.length()))) {
                result = s.substring(i, j);
            }
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }
        return result;
    }

    private boolean has(Map<Character, Integer> map) {
        for (int num : map.values()) {
            if (num > 0) {
                return true;
            }
        }
        return false;
    }
}
