package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 50. Pow(x, n)
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 2) {
            return x * x;
        }
        if (n == -2) {
            return 1 / (x * x);
        }

        boolean isOdd = n % 2 != 0;
        int mid = isOdd ? (n - 1) / 2 : n / 2;

        double midResult = myPow(x, mid);
        return isOdd ? midResult * midResult * x : midResult * midResult;
    }
}
