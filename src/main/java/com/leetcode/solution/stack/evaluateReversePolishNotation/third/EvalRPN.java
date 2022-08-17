package com.leetcode.solution.stack.evaluateReversePolishNotation.third;

import com.leetcode.solution.stack.evaluateReversePolishNotation.EvalRPNTemplate;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN extends EvalRPNTemplate {
    @Override
    public int evalRPN(String[] tokens) {
        // 思路：数字入栈，如果是操作符出两个数字进行运算，之后将运算结果入栈
        if (tokens == null || tokens.length == 0) {
            return -1;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if (isOperate(current)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(operate(left, right, current));
            } else {
                stack.push(Integer.parseInt(current));
            }
        }

        return stack.pop();
    }

    private boolean isOperate(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    private int operate(int left, int right, String operate) {
        if ("+".equals(operate)) {
            return left + right;
        }

        if ("-".equals(operate)) {
            return left - right;
        }

        if ("*".equals(operate)) {
            return left * right;
        }

        return left / right;
    }
}
