package com.leetcode.solution.backtracking.grayCode.second;

import com.leetcode.solution.backtracking.grayCode.GrayCodeTemplate;

import java.util.ArrayList;
import java.util.List;

public class GrayCode extends GrayCodeTemplate {
    @Override
    public List<Integer> grayCode(int n) {
        // Ideas: backtracking
        // 1. Is need Sort => no
        // 2. Is need element index => no
        // 3. helper => void helper(List<Integer> result, StringBuffer stringBuffer, int n, int left, int right)
        // 4. when exit recursion => stringBuffer.length() >= n
        // 5. when single result add to solution set => stringBuffer.length() >= n
        // 6. pruning => no
        // 7. recursive decomposition sub problem to next level => binary
        // 8. how to backtracking => single result delte last element
        // solution set
        List<Integer> result = new ArrayList<>();

        // check input
        if (n < 1) {
            return result;
        }

        // single result + calculate solution set
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, 0, 1);
        return result;
    }

    private void helper(List<Integer> result, StringBuffer stringBuffer, int n, int left, int right) {
        // exit recursion + single result add to solution set
        if (stringBuffer.length() >= n) {
            result.add(Integer.parseInt(stringBuffer.toString(), 2));
            return;
        }

        stringBuffer.append(left);
        helper(result, stringBuffer, n, 0, 1);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        stringBuffer.append(right);
        helper(result, stringBuffer, n, 1, 0);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }
}
