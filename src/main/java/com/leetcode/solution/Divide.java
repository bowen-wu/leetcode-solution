package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 29. 两数相除
 */
public class Divide {
    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        if (divisor == 1) {
            return dividend;
        }
        int result = 0;
        int remainder = dividend < 0 ? -dividend : dividend;
        int copyDivisor = divisor < 0 ? -divisor : divisor;
        while (true) {
            remainder = remainder - copyDivisor;
            if (remainder < 0) {
                if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
                    // 返回负数
                    return -result;
                }
                return result;
            }
            result++;
        }
    }
}
