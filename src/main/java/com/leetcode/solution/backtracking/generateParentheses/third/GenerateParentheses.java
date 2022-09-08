package com.leetcode.solution.backtracking.generateParentheses.third;

import com.leetcode.solution.backtracking.generateParentheses.GenerateParenthesesTemplate;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses extends GenerateParenthesesTemplate {
    @Override
    public List<String> generateParenthesis(int n) {
        // Ideas: backtracking
        // is need sort => no
        // is need element position index => no
        // helper => void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining)
        // when exit recursion => leftRemainging == 0 && rightRemaining == 0
        // when single result add to solution set => leftRemainging == 0 && rightRemaining == 0
        // pruning => no
        // recursive decomposition sub problem to next level => leftRemaining > 0 + rightRemaining > leftRemaining
        // how to backtrack => single result delete last element
        // solution set
        List<String> result = new ArrayList<>();

        // check input
        if (n < 1) {
            return result;
        }

        // single result + calculate solution set => single result add to solution set
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, n);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining) {
        // when exit recursion
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(stringBuffer.toString());
            return;
        }

        if (leftRemaining > 0) {
            stringBuffer.append("(");
            helper(result, stringBuffer, leftRemaining - 1, rightRemaining);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (rightRemaining > leftRemaining) {
            stringBuffer.append(")");
            helper(result, stringBuffer, leftRemaining, rightRemaining - 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
