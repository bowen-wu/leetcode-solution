package com.leetcode.solution.doublePointer.validPalindrome.second;

import com.leetcode.solution.doublePointer.validPalindrome.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {
    @Override
    public boolean isPalindrome(String s) {
        // 字母和数字都属于字母数字字符
        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isBetterAndNumber(s.charAt(start))) {
                start++;
            } else if (!isBetterAndNumber(s.charAt(end))) {
                end--;
            } else {
                if (!equal(s.charAt(start), s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isBetterAndNumber(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private boolean equal(char ch1, char ch2) {
        if (ch1 >= 'A' && ch1 <= 'Z') {
            ch1 = (char) (ch1 + 'a' - 'A');
        }
        if (ch2 >= 'A' && ch2 <= 'Z') {
            ch2 = (char) (ch2 + 'a' - 'A');
        }
        return ch1 == ch2;
    }
}
