package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * 467. 环绕字符串中唯一的子字符串
 * TODO：动态规划
 */
public class FindSubstringInWraproundString {
    public static void main(String[] args) {
        System.out.println(new FindSubstringInWraproundString().findSubstringInWraproundString("a")); // 1
        System.out.println(new FindSubstringInWraproundString().findSubstringInWraproundString("cac")); // 2
        System.out.println(new FindSubstringInWraproundString().findSubstringInWraproundString("zab")); // 6
        System.out.println(new FindSubstringInWraproundString().findSubstringInWraproundString("abcd")); // 10
        System.out.println(new FindSubstringInWraproundString().findSubstringInWraproundString("bcdcde")); // 9
    }

    public int findSubstringInWraproundString(String p) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        char prevChar = p.charAt(0);
        StringBuilder stringBuilder = new StringBuilder(Character.toString(prevChar));

        for (int i = 0; i < p.length(); i++) {
            char currentChar = p.charAt(i);
            if (currentChar - prevChar == 1 || (currentChar == 'a' && prevChar == 'z')) {
                stringBuilder.append(currentChar);
            } else {
                result += getSubStringNumber(stringIntegerMap, stringBuilder);
                stringBuilder = new StringBuilder(Character.toString(currentChar));
            }
            if (map.get(currentChar) == null) {
                result++;
                map.put(currentChar, 1);
            }
            prevChar = currentChar;
        }

        result += getSubStringNumber(stringIntegerMap, stringBuilder);

        return result;
    }

    private int getSubStringNumber(Map<String, Integer> stringIntegerMap, StringBuilder stringBuilder) {
        int result = 0;
        if (stringBuilder.length() > 1) {
            String currentStr = stringBuilder.toString();
            for (int j = 0; j < currentStr.length() - 1; j++) {
                for (int k = j + 1; k < currentStr.length(); k++) {
                    String sub = currentStr.substring(j, k);
                    if (stringIntegerMap.get(sub) == null) {
                        result++;
                        stringIntegerMap.put(sub, 1);
                    }
                }
            }
        }
        return result;
    }
}
