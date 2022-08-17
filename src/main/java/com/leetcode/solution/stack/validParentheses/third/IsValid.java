package com.leetcode.solution.stack.validParentheses.third;

import com.leetcode.solution.stack.validParentheses.IsValidTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsValid extends IsValidTemplate {
    @Override
    public boolean isValid(String s) {
        // 思路：如果是左括号，直接入栈，如果是右括号，拿出栈顶元素，查看是否匹配
        // case：}} => 如果栈空但是是右括号，false
        // case：{{ => 如果栈剩余，则 false
        if (s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '[' || currentChar == '(' || currentChar == '{') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), currentChar)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }
}
