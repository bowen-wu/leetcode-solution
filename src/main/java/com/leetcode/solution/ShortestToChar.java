package com.leetcode.solution;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * 821. 字符的最短距离
 */
public class ShortestToChar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestToChar().shortestToChar1("aaabcaab", 'b')));
    }

    public int[] shortestToChar1(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

    // 时间复杂度：O(s.length) + O(s.length - 1) => O(n)
    // 空间复杂度：O(1)
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int prevVisibleIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                for (int j = Math.max(prevVisibleIndex, 0); j < i; j++) {
                    // i - j => aaa => [3,2,1]
                    // Math.min(i - j, result[j]) => caa => [1,2,1]
                    result[j] = prevVisibleIndex != -1 ? Math.min(i - j, result[j]) : i - j;
                }
                prevVisibleIndex = i;
            } else if (prevVisibleIndex != -1) {
                // caa => [1,2,3]
                result[i] = i - prevVisibleIndex;
            }
        }
        return result;
    }
}
