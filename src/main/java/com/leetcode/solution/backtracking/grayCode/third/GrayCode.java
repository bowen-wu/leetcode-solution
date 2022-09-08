package com.leetcode.solution.backtracking.grayCode.third;

import com.leetcode.solution.backtracking.grayCode.GrayCodeTemplate;

import java.util.ArrayList;
import java.util.List;

public class GrayCode extends GrayCodeTemplate {
    @Override
    public List<Integer> grayCode(int n) {
        // Ideas: backtracking
        // is need sort => no
        // is need element position index => yes
        // helper => void helper(List<Integer> result, StringBuffer stringBuffer, int n, int start, int end)
        // when exit recursion => n == 0
        // when single result add to solution set => n == 0
        // pruning
        // recursive decomposition sub problem to next level => add start + add end
        // how to backtrack => single result delete last element
        // solution set
        List<Integer> result = new ArrayList<>();

        // check input
        if (n < 1) {
            return result;
        }

        // single result + calculate solution set => single result add to solution set
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, 0, 1);
        return result;
    }

    private void helper(List<Integer> result, StringBuffer stringBuffer, int n, int start, int end) {
        // exit recursion + single result add to solution set
        if (n == 0) {
            result.add(Integer.parseInt(stringBuffer.toString(), 2));
            return;
        }

        stringBuffer.append(start);
        helper(result, stringBuffer, n - 1, 0, 1);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        stringBuffer.append(end);
        helper(result, stringBuffer, n - 1, 1, 0);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }
}
