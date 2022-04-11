package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * 357. 统计各位数字都不同的数字个数
 */

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }

        int currentResult = 9;
        int currentSelectCount = 9;
        for (int i = n - 1; i >= 1; i--) {
            currentResult *= currentSelectCount;
            currentSelectCount--;
        }

        return countNumbersWithUniqueDigits(n - 1) + currentResult;
    }

}
