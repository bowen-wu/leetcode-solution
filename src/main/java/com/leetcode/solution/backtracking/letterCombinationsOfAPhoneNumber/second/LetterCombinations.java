package com.leetcode.solution.backtracking.letterCombinationsOfAPhoneNumber.second;

import com.leetcode.solution.backtracking.letterCombinationsOfAPhoneNumber.LetterCombinationsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations extends LetterCombinationsTemplate {
    private Map<Character, List<Character>> map;

    @Override
    public List<String> letterCombinations(String digits) {
        // Ideas: backtracking => 排列问题
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置 => 需要
        // 3. helper 函数定义 => void helper(List<String> result, StringBuffer stringBuffer, String digits, int position)
        // 4. 递归何时退出 => position >= digits.length()
        // 5. 单一解何时加入解集 => position >= digits.length()
        // 6. 剪枝
        // 7. 如何分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 9. 优化 => position 可以使用 stringBuffer 的 length 代替
        map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, digits);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, String digits) {
        // 递归何时退出 + 单一解加入解集中
        if (stringBuffer.length() >= digits.length()) {
            result.add(stringBuffer.toString());
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (Character character : map.get(digits.charAt(stringBuffer.length()))) {
            stringBuffer.append(character);
            helper(result, stringBuffer, digits);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
