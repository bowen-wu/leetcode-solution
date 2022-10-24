package com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.second;

import com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.StrStrTemplate;

public class StrStr extends StrStrTemplate {

    @Override
    public int strStrRabinKarp(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();

        // hash 算法 => 31 算法
        // 最高位贡献
        int higher = 1;
        int mod = 9999991;
        for (int i = 1; i < nLen; i++) {
            higher = (higher * 31) % mod;
        }

        int hashcode = hash(needle);
        String first = haystack.substring(0, nLen);
        int firstHashcode = hash(first);
        if (hashcode == firstHashcode && isMatch(needle, first)) {
            return 0;
        }


        for (int i = 1; i < hLen - nLen + 1; i++) {
            firstHashcode = (firstHashcode - (haystack.charAt(i - 1) * higher) % mod + mod) % mod;
            firstHashcode = (31 * firstHashcode + haystack.charAt(i + nLen - 1)) % mod;
            if (hashcode == firstHashcode && isMatch(needle, haystack.substring(i, i + nLen))) {
                return i;
            }
        }

        return -1;
    }

    private boolean isMatch(String source, String target) {
        int sLen = source.length();
        for (int i = 0; i < sLen; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = (result * 31 + str.charAt(i)) % 9999991;
        }
        return result;
    }

    @Override
    public int strStrBF(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i < hLen - nLen + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            int j = 0;
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == nLen) {
                return i;
            }
        }
        return -1;
    }
}
