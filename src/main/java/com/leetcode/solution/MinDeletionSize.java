package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * 944. 删列造序
 */
public class MinDeletionSize {
    public static void main(String[] args) {
        System.out.println(new MinDeletionSize().minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    // 时间复杂度：O(m * n) => m 是字符串的长度  n 是 strs 的长度
    // 空间复杂度：O(1)
    public int minDeletionSize(String[] strs) {
        int result = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
