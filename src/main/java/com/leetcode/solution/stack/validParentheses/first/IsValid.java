package com.leetcode.solution.stack.validParentheses.first;

import com.leetcode.solution.stack.validParentheses.IsValidTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid extends IsValidTemplate {
    @Override
    public boolean isValid(String s) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                // 仅仅关心不匹配
                if (!isMatch(stack.pop(), currentChar)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char prev, char current) {
        return (prev == '{' && current == '}') || (prev == '[' && current == ']') || (prev == '(' && current == ')');
    }
}
