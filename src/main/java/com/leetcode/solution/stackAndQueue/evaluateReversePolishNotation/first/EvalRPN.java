package com.leetcode.solution.stackAndQueue.evaluateReversePolishNotation.first;

import com.leetcode.solution.stackAndQueue.evaluateReversePolishNotation.EvalRPNTemplate;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN extends EvalRPNTemplate {
    @Override
    public int evalRPN(String[] tokens) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (tokens == null || tokens.length == 0) {
            return Integer.MIN_VALUE;
        }

        Deque<Integer> stack = new LinkedList<>();
        for (String current : tokens) {
            if (isOperate(current)) {
                Integer right = stack.pop();
                Integer left = stack.pop();
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

    private boolean isOperate(String current) {
        return "+".equals(current) || "-".equals(current) || "*".equals(current) || "/".equals(current);
    }
}
