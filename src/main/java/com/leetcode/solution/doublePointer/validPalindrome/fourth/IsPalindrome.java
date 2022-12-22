package com.leetcode.solution.doublePointer.validPalindrome.fourth;

import com.leetcode.solution.doublePointer.validPalindrome.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {
    @Override
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (!isLetterOrNum(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isLetterOrNum(s.charAt(right))) {
                right--;
                continue;
            }

            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);

            if (leftCh >= 'A' && leftCh <= 'Z') {
                leftCh = (char) (leftCh - ('A' - 'a'));
            }

            if (rightCh >= 'A' && rightCh <= 'Z') {
                rightCh = (char) (rightCh - ('A' - 'a'));
            }
            if (leftCh != rightCh) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isLetterOrNum(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
