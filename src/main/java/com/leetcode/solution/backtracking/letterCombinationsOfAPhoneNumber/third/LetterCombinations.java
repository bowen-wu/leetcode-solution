package com.leetcode.solution.backtracking.letterCombinationsOfAPhoneNumber.third;

import com.leetcode.solution.backtracking.letterCombinationsOfAPhoneNumber.LetterCombinationsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations extends LetterCombinationsTemplate {
    @Override
    public List<String> letterCombinations(String digits) {
        // Ideas: backtracking => 排列问题
        // is need sort => no
        // is need element position index => yes
        // helper => void helper(List<String> result, StringBuffer stringBuffer, String digits, int position)
        // when exit recursion => position >= digits.length()
        // when single result add to solution set => position >= digits.length()
        // pruning => no
        // recursive decomposition sub problem to next level => for loop
        // how to backtrack => single result delete last element
        // solution set
        List<String> result = new ArrayList<>();

        // check input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // single result + calculate solution set => single result add to solution set
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, digits, 0);
        return result;
    }

    private void helper(List<String> result, StringBuffer stringBuffer, String digits, int position) {
        // exit recursion + single result add to solution set
        if (position >= digits.length()) {
            result.add(stringBuffer.toString());
            return;
        }

        for (Character character : getCharacterList(digits.charAt(position))) {
            stringBuffer.append(character);
            helper(result, stringBuffer, digits, position + 1);

            // how to backtrack
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }

    private List<Character> getCharacterList(char ch) {
        switch (ch) {
            case '2':
                return Arrays.asList('a', 'b', 'c');
            case '3':
                return Arrays.asList('d', 'e', 'f');
            case '4':
                return Arrays.asList('g', 'h', 'i');
            case '5':
                return Arrays.asList('j', 'k', 'l');
            case '6':
                return Arrays.asList('m', 'n', 'o');
            case '7':
                return Arrays.asList('p', 'q', 'r', 's');
            case '8':
                return Arrays.asList('t', 'u', 'v');
            case '9':
                return Arrays.asList('w', 'x', 'y', 'z');
            default:
                throw new IllegalArgumentException("Invalid params");
        }
    }
}
