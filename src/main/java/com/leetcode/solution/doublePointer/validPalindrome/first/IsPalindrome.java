package com.leetcode.solution.doublePointer.validPalindrome.first;

import com.leetcode.solution.doublePointer.validPalindrome.IsPalindromeTemplate;

public class IsPalindrome extends IsPalindromeTemplate {
    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("OP"));
    }

    @Override
    public boolean isPalindrome(String s) {
        // 字母和数字都属于字母数字字符
        if (s == null || s.length() == 0) {
            return false;
        }

        String str = s.toLowerCase();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (!isLetter(str.charAt(start))) {
                start++;
            } else if (!isLetter(str.charAt(end))) {
                end--;
            } else {
                char startCh = str.charAt(start);
                char endCh = str.charAt(end);
                if (startCh >= 'A' && startCh <= 'Z') {
                    startCh += 'a' - 'A';
                }
                if (endCh >= 'A' && endCh <= 'Z') {
                    endCh += 'a' - 'A';
                }
                if (startCh != endCh) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
