package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/consecutive-numbers-sum/
 * 829. 连续整数求和
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(18)); // 3
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(16)); // 1
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(3)); // 2
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(5)); // 2
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(50)); // 3
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(78729668)); // 2
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(84418900)); // 24
    }

    public int consecutiveNumbersSum(int n) {
        int result = 1;
        int end = (n % 2 != 0) ? (n / 2 + 1) : (n / 3 + 1);
        int minStart = end - 1;
        while (minStart >= 1) {
            int start = end - 1;
            int sum = start;
            while (sum < n - end) {
                start--;
                if (start < 1) {
                    return result;
                }
                sum += start;
            }
            if (start < minStart) {
                minStart = start;
            }
            if (sum == n - end) {
                result++;
            }
            end--;
        }
        return result;
    }
}
