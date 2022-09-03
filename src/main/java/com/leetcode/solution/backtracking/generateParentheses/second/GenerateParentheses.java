package com.leetcode.solution.backtracking.generateParentheses.second;

import com.leetcode.solution.backtracking.generateParentheses.GenerateParenthesesTemplate;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses extends GenerateParenthesesTemplate {
    @Override
    public List<String> generateParenthesis(int n) {
        // Ideas: backtracking => 排列问题
        // 1. Is need sort => no
        // 2. Is need element index => no
        // 3. helper => void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining)
        // 4. when exit recursion => leftRemaining == 0 && rightRemaining == 0
        // 5. when single result add to solution set => leftRemaining == 0 && rightRemaining == 0
        // 6. pruning => no
        // 7. recursive decomposition subproblem to next level => for loop
        // 8. how to backtracking => delete single result last element
        // solution set
        List<String> result = new ArrayList<>();

        // check input
        if (n < 1) {
            return result;
        }

        // single result + calculate solution set
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, n);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining) {
        // exit recursion + single result add to solution set
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
