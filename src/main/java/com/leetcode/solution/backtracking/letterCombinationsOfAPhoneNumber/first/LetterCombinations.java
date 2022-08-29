package com.leetcode.solution.backtracking.letterCombinationsOfAPhoneNumber.first;

import com.leetcode.solution.backtracking.letterCombinationsOfAPhoneNumber.LetterCombinationsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations extends LetterCombinationsTemplate {
    @Override
    public List<String> letterCombinations(String digits) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => ` void helper(List<String> result, List<String> list, String digits, int position) `
        // 4. 递归何时退出 => position == digits.length()
        // 5. 单一解何时加入解集 => position == digits.length()
        // 6. 剪枝
        // 7. 如何分解子问题到下一层 => for(int i = 0; i < map.get(digits[position]).length(); i++)
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解如何加入到解集中
        List<String> list = new ArrayList<>();
        helper(result, list, digits);
        return result;
    }

    private void helper(List<String> result, List<String> list, String digits) {
        // 递归何时退出
        if (list.size() == digits.length()) {
            result.add(String.join("", list));
            return;
        }

        // 分解子问题到下一层
        for (String s : getStr(digits.charAt(list.size()))) {
            list.add(s);
            helper(result, list, digits);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }

    private List<String> getStr(char c) {
        switch (c) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                throw new IllegalArgumentException("The params c is invalid!");
        }
    }
}
