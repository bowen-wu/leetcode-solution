package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * 806. 写字符串需要的行数
 */
public class NumberOfLines {
    public static void main(String[] args) {
        System.out.println(new NumberOfLines().numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));
    }

    /**
     * 806. 写字符串需要的行数
     * 时间复杂度 O(n)
     * 空间复杂度
     */
    public int[] numberOfLines(int[] widths, String s) {
        if (s.length() == 0) {
            return new int[]{0, 0};
        }
        String words = "abcdefghijklmnopqrstuvwxyz";

        int reminder = 100;
        int lineNumber = 1;
        int lastLineUsed = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentNumber = widths[words.indexOf(currentChar)];
            if (reminder - currentNumber >= 0) {
                // 可以减
                reminder -= currentNumber;
                lastLineUsed += currentNumber;
            } else {
                // 换行
                lineNumber++;
                reminder = 100 - currentNumber;
                lastLineUsed = currentNumber;
            }
        }

        return new int[]{lineNumber, lastLineUsed};
    }
}
