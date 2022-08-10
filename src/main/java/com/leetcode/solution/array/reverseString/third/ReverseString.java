package com.leetcode.solution.array.reverseString.third;

import com.leetcode.solution.array.reverseString.ReverseStringTemplate;

public class ReverseString extends ReverseStringTemplate {
    @Override
    public void reverseString(char[] s) {
        // 思路
        // 双指针 => 两两调换。O(n) + O(1)
        if (s == null || s.length == 0) {
            return;
        }
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - i - 1);
        }
    }

    private void swap(char[] s, int first, int second) {
        char temp = s[first];
        s[first] = s[second];
        s[second] = temp;
    }
}
