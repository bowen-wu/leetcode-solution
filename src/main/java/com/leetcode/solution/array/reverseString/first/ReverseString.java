package com.leetcode.solution.array.reverseString.first;

import com.leetcode.solution.array.reverseString.ReverseStringTemplate;

public class ReverseString extends ReverseStringTemplate {
    public void reverseString(char[] s) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
