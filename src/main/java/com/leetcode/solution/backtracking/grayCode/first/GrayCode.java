package com.leetcode.solution.backtracking.grayCode.first;

import com.leetcode.solution.backtracking.grayCode.GrayCodeTemplate;

import java.util.ArrayList;
import java.util.List;

public class GrayCode extends GrayCodeTemplate {
    @Override
    public List<Integer> grayCode(int n) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素索引 => 不需要
        // 3. helper 函数定义 => ` void helper(List<Integer> result, List<Integer> list, int[] nums) `
        // 4. 递归何时退出 => 找到一个结果
        // 5. 单一解何时加入解集 => list.size() == nums.length && isValid
        // 6. 剪枝 => 找到一个结果就退出
        // 7. 如何分解子问题到下一层 => for => 注意一个数字只能使用一次
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<Integer> result = new ArrayList<>();

        if (n < 1) {
            return result;
        }

        // 单一解 + 计算解集
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, n, 0, 1);
        return result;
    }

    private void helper(List<Integer> result, StringBuffer stringBuffer, int n, int left, int right) {
        // 递归何时退出 + 单一解何时加入解集
        if (stringBuffer.length() == n) {
            result.add(Integer.valueOf(stringBuffer.toString(), 2));
            return;
        }

        // 分解子问题到下一层
        stringBuffer.append(left);
        helper(result, stringBuffer, n, 0, 1);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        stringBuffer.append(right);
        helper(result, stringBuffer, n, 1, 0);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }
}
