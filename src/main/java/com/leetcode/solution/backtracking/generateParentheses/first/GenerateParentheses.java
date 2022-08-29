package com.leetcode.solution.backtracking.generateParentheses.first;

import com.leetcode.solution.backtracking.generateParentheses.GenerateParenthesesTemplate;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses extends GenerateParenthesesTemplate {
    @Override
    public List<String> generateParenthesis(int n) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => ` void helper(List<String> result, List<String> list, int n, int left, int right) `
        // 4. 递归何时退出 => list.size() == n * 2
        // 5. 单一解何时加入解集 => isValidParentheses && list.size() == n * 2
        // 6. 剪枝
        // 7. 如何递归子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解移除最后一个元素
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (n < 1) {
            return result;
        }

        // 单一解 + 计算解集 => 将单一解加入解集中
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, n);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, int leftRemaining, int rightRemaining) {
        // 递归何时退出 + 单一解何时加入解集
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(stringBuffer.toString());
            return;
        }

        // 递归分解子问题到下一层
        if (leftRemaining > 0) {
            stringBuffer.append('(');
            helper(result, stringBuffer, leftRemaining - 1, rightRemaining);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (rightRemaining > leftRemaining) {
            stringBuffer.append(')');
            helper(result, stringBuffer, leftRemaining, rightRemaining - 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    private void helper(List<String> result, StringBuffer stringBuffer, int n, int leftRemaining, int rightRemaining) {
        // 递归何时退出 + 单一解何时加入解集
        if (stringBuffer.length() == 2 * n) {
            result.add(stringBuffer.toString());
            return;
        }

        // 剪枝
        if (leftRemaining > rightRemaining) {
            return;
        }

        // 剪枝
        // 递归分解子问题到下一层
        for (int i = 0; i < 2; i++) {
            // 剪枝
            if ((i == 0 && leftRemaining == 0) || (i == 1 && rightRemaining == 0)) {
                continue;
            }
            stringBuffer.append(i == 0 ? '(' : ')');
            helper(result, stringBuffer, n, i == 0 ? leftRemaining - 1 : leftRemaining, i == 1 ? rightRemaining - 1 : rightRemaining);

            // 何时回溯
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
