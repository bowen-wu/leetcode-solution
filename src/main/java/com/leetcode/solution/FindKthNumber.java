package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 * 668. 乘法表中第k小的数
 */
public class FindKthNumber {
    public static void main(String[] args) {
        System.out.println(new FindKthNumber().findKthNumber(3, 3, 5));
//        System.out.println(new FindKthNumber().findKthNumber(9895, 28405, 100787757));
//        System.out.println(new FindKthNumber().findKthNumber(14095, 1517, 8568032));
    }

    // 时间复杂度：O(m * n)
    // 空间复杂度：
    public int findKthNumber(int m, int n, int k) {
        if (k == 1) {
            return 1;
        }
        if (k == m * n) {
            return m * n;
        }

        int number = 0;
        int result = -1;
        if (m * n / 2 > k) {
            for (int i = 1; i <= m * n; i++) {
                int iNumber = getNumber(i, m, n);
                if (number + iNumber >= k) {
                    result = i;
                    break;
                }
                number += iNumber;
            }
        } else {
            for (int i = m * n; i > 0; i--) {
                int iNumber = getNumber(i, m, n);
                if (number + iNumber > m * n - k) {
                    result = i;
                    break;
                }
                number += iNumber;
            }
        }

        return result;
    }

    private int getNumber(int currentNumber, int m, int n) {
        int number = 0;
        int minRow = (currentNumber - 1) / n + 1;
        int maxRow = Math.min(currentNumber, m);
        for (int i = minRow; i <= maxRow; i++) {
            int minColumn = (currentNumber - 1) / i + 1;
            int maxColumn = Math.min(currentNumber / i, n);
            for (int j = minColumn; j <= maxColumn; j++) {
                number++;
            }
        }
        return number;
    }
}
