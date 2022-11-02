package com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.third;

import com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.StrStrTemplate;

public class StrStr extends StrStrTemplate {
    @Override
    public int strStrBF(String haystack, String needle) {
        // check input
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        char firstChar = needle.charAt(0);
        for (int i = 0; i <= hLen - nLen; i++) {
            char ch = haystack.charAt(i);
            if (ch == firstChar && isMatch(haystack, i, needle, nLen)) {
                return i;
            }
        }

        return -1;
    }

    private int random = 31;
    private int mod = 999991;

    @Override
    public int strStrRabinKarp(String haystack, String needle) {
        // check input
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        int targetHash = hash(needle);
        int high = 1;
        for (int i = 1; i < nLen; i++) {
            high = (high * random) % mod;
        }

        String firstStr = haystack.substring(0, nLen);
        int sourceHash = hash(firstStr);
        if (sourceHash == targetHash && isMatch(haystack, 0, needle, nLen)) {
            return 0;
        }

        for (int i = 1; i <= hLen - nLen; i++) {
            sourceHash = (((sourceHash - (high * haystack.charAt(i - 1)) % mod + mod) % mod) * random + haystack.charAt(i + nLen - 1)) % mod;

            if (sourceHash == targetHash && isMatch(haystack, i, needle, nLen)) {
                return i;
            }
        }

        return -1;
    }

    private int hash(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = (result * random + str.charAt(i)) % mod;
        }
        return result;
    }

    private boolean isMatch(String source, int start, String target, int len) {
        for (int i = 1; i < len; i++) {
            if (source.charAt(start + i) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
