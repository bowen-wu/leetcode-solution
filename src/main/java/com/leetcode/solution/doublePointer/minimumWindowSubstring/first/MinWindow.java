package com.leetcode.solution.doublePointer.minimumWindowSubstring.first;

import com.leetcode.solution.doublePointer.minimumWindowSubstring.MinWindowTemplate;

import java.util.HashMap;
import java.util.Map;

public class MinWindow extends MinWindowTemplate {
    public static void main(String[] args) {
        new MinWindow().minWindow("ADOBECODEBANC", "ABC");
    }

    @Override
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        String result = "";
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        // double pointer
        int i = 0;
        int j = 0;

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!allFound(map)) {
                    map[s.charAt(j)]--;
                    j++;
                } else {
                    break;
                }
            }

            // 全部找到了 => 收窄
            if (allFound(map) && j - i < minLength) {
                minLength = j - i;
                result = s.substring(i, j);
            }
            map[s.charAt(i)]++;
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

    public String minWindowWithMap(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        // double pointer
        int i = 0;
        int j = 0;

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!allFound(map)) {
                    char ch = s.charAt(j);
                    if (map.containsKey(ch)) {
                        map.merge(ch, -1, Integer::sum);
                    }
                    j++;
                } else {
                    break;
                }
            }

            // 全部找到了 => 收窄
            if (allFound(map) && j - i < minLength) {
                minLength = j - i;
                result = s.substring(i, j);
            }
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.merge(ch, 1, Integer::sum);
            }
        }

        return result;
    }

    private boolean allFound(Map<Character, Integer> map) {
        for (int num : map.values()) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
