package com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.first;

import com.leetcode.solution.doublePointer.findTheIndexOfTheFirstOccurrenceInAString.StrStrTemplate;

public class StrStr extends StrStrTemplate {
    public static void main(String[] args) {
        System.out.println(new StrStr().strStrRabinKarp("mississippi", "issi"));
    }

    @Override
    public int strStrRabinKarp(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();

        // 用于计算 hashcode
        int r = 31;
        int base = 999991;

        // 最高位的贡献
        int highRotate = 1;
        for (int i = 1; i < nLen; i++) {
            highRotate = (r * highRotate) % base;
        }

        int nHash = hash(needle, r, base, 0, nLen);
        int hHash = hash(haystack, r, base, 0, nLen);

        if (nHash == hHash && isMatch(needle, haystack, 0)) {
            return 0;
        }

        for (int i = 1; i < hLen - nLen + 1; i++) {
            // 减去前一个字符的贡献 => hHash - highRotate * haystack.charAt(i - 1) 可能是负数
            hHash = (hHash - highRotate * haystack.charAt(i - 1) % base + base) % base;

            // 添加 i + nLen - 1 的字符的贡献
            hHash = (r * hHash + haystack.charAt(i + nLen - 1)) % base;
            if (nHash == hHash && isMatch(needle, haystack, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isMatch(String target, String source, int start) {
        for (int i = start; i < target.length(); i++) {
            if (target.charAt(i) != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String needle, int r, int mod, int start, int len) {
        int hashcode = 0;
        for (int i = start; i < len; i++) {
            hashcode = (hashcode * r + needle.charAt(i)) % mod;
        }

        return hashcode;
    }


    @Override
    public int strStrBF(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        // double pointer
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i < hLen - nLen + 1; i++) {
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
