package com.leetcode.solution.doublePointer.minimumWindowSubstring.fourth;

import com.leetcode.solution.doublePointer.minimumWindowSubstring.MinWindowTemplate;

public class MinWindow extends MinWindowTemplate {
    @Override
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        int[] set = new int[128];
        int tLen = t.length();
        int sLen = s.length();
        for (int i = 0; i < tLen; i++) {
            set[t.charAt(i)] += 1;
        }

        String result = "";
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < sLen; i++) {
            while (j < sLen && !findAll(set)) {
                set[s.charAt(j)] -= 1;
                j++;
            }

            if (min > j - i && findAll(set)) {
                result = s.substring(i, j);
                min = j - i;
            }
            set[s.charAt(i)] += 1;
        }

        return min == Integer.MAX_VALUE ? "" : result;
    }

    private boolean findAll(int[] set) {
        int len = set.length;
        for (int i = 0; i < len; i++) {
            if (set[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
