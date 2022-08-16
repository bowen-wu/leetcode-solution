package com.leetcode.solution.stack.evaluateReversePolishNotation.second;

import com.leetcode.solution.stack.evaluateReversePolishNotation.EvalRPNTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN extends EvalRPNTemplate {
    // 思路：使用栈模拟。遇到数字入栈，遇到 + - * / pop 两个值，进行运算，之后将结果压栈
    @Override
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return Integer.MIN_VALUE;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if (isOperate(current) && !stack.isEmpty()) {
                int right = stack.pop();
                int left = stack.pop();
                switch (current) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    default:
                        stack.push(left / right);
                }
            } else {
                stack.push(Integer.parseInt(current));
            }
        }

        return stack.pop();
    }

    private boolean isOperate(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }
}
