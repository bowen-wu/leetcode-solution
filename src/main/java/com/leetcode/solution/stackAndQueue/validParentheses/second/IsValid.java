package com.leetcode.solution.stackAndQueue.validParentheses.second;

import com.leetcode.solution.stackAndQueue.validParentheses.IsValidTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsValid extends IsValidTemplate {
    // 思路：使用栈进行模拟，遇到左括号入栈，遇到右括号和栈顶左括号匹配
    // 栈空，此时来了右括号，false
    // 循环结束，栈不空 false
    @Override
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), current)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        return (left == '{' && right == '}') || (left == '[' && right == ']') || (left == '(' && right == ')');
    }
}
