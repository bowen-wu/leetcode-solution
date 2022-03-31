package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 28. 实现 strStr()
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        int needleLength = needle.length();
        for (int i = 0; i <= haystack.length() - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
