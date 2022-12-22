package com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.fourth;

import com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.StrStrTemplate;

public class StrStr extends StrStrTemplate {
    @Override
    public int strStrRabinKarp(String haystack, String needle) {
        return 0;
    }

    @Override
    public int strStrBF(String haystack, String needle) {
       if (haystack == null || needle == null || needle.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }

        char firstMatch = needle.charAt(0);
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i < haystackLen - needleLen + 1; i++) {
            if (haystack.charAt(i) == firstMatch && matchAll(haystack, i, needle)) {
                return i;
            }
        }

        return -1;
    }

    private boolean matchAll(String source, int start, String target) {
        int len = target.length();
        for (int i = 0; i < len; i++) {
            if (source.charAt(i + start) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
