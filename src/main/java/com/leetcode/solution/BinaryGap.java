package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/binary-gap/solution/er-jin-zhi-jian-ju-by-leetcode-solution-dh2q/
 * 868. 二进制间距
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(8));
    }

    // 时间复杂度：O(log n)
    // 空间复杂度：O(1)
    public int binaryGap(int n) {
        int result = 0;
        int prev = -1;
        int index = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                if (prev != -1) {
                    result = Math.max(index - prev, result);
                }
                prev = index;
            }

            n = n / 2;
            index++;
        }

        return result;
    }
}
