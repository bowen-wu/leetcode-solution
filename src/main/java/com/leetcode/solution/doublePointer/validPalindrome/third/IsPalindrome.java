package com.leetcode.solution.doublePointer.validPalindrome.third;

import com.leetcode.solution.doublePointer.validPalindrome.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {
    @Override
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch - ('A' - 'a')));
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }

        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
