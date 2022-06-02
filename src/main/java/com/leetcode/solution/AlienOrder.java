package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/Jf1JuT/
 * 剑指 Offer II 114. 外星文字典
 * TODO: 拓扑排序
 */
public class AlienOrder {
    public static void main(String[] args) {
        System.out.println(new AlienOrder().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"})); // wertf
//        System.out.println(new AlienOrder().alienOrder(new String[]{"z", "x"})); // zx
//        System.out.println(new AlienOrder().alienOrder(new String[]{"z", "x", "z"})); // ""
//        System.out.println(new AlienOrder().alienOrder(new String[]{"z", "z"})); // z
//        System.out.println(new AlienOrder().alienOrder(new String[]{"zy", "zx"})); // yxz
//        System.out.println(new AlienOrder().alienOrder(new String[]{"zy"})); // yz
//        System.out.println(new AlienOrder().alienOrder(new String[]{"abc", "ab"})); // ""
    }

    public String alienOrder(String[] words) {
        Stack<List<Character>> pendingOrder = new Stack<>();
        List<Character> characters = new ArrayList<>();

        String prevWord = words[0];
        for (int j = 0; j < prevWord.length() - 1; j++) {
            char firstChar = prevWord.charAt(j);
            char secondChar = prevWord.charAt(j + 1);
            pendingOrder.push(Arrays.asList(secondChar, firstChar));
        }
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            if (i == words.length - 2) {
                for (int j = 0; j < currentWord.length() - 1; j++) {
                    char firstChar = currentWord.charAt(j);
                    char secondChar = currentWord.charAt(j + 1);
                    pendingOrder.push(Arrays.asList(secondChar, firstChar));
                }
            }
            List<Character> twoCharOrder = compareTwoWord(prevWord, currentWord);
            if (twoCharOrder == null) {
                return "";
            }
            pendingOrder.add(twoCharOrder);
            prevWord = currentWord;
        }

        while (pendingOrder.size() > 0) {
            List<Character> pop = pendingOrder.pop();
            String singleOrderResult = judgeOrder(pop, characters, pendingOrder);
            if (singleOrderResult == null) {
                return "";
            }
        }

        return characters.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private String judgeOrder(List<Character> twoCharOrder, List<Character> characters, Stack<List<Character>> pendingOrder) {
        char firstChar = twoCharOrder.get(0);
        char secondChar = twoCharOrder.get(1);
        if (characters.isEmpty()) {
            characters.add(firstChar);
            if (firstChar != secondChar) {
                characters.add(secondChar);
            }
            return "";
        }

        int firstCharIndex = characters.indexOf(firstChar);
        int secondCharIndex = characters.indexOf(secondChar);

        // 两者都在
        if (firstCharIndex >= 0 && secondCharIndex >= 0) {
            if (firstCharIndex > secondCharIndex) {
                return null;
            }
        } else if (firstCharIndex >= 0 && secondCharIndex < 0) {
            // first 在
            characters.add(firstCharIndex + 1, secondChar);
        } else if (firstCharIndex < 0 && secondCharIndex >= 0) {
            // second 在
            characters.add(secondCharIndex, firstChar);
        } else {
            // 两个都不在不能判断顺序
            pendingOrder.add(twoCharOrder);
        }
        return "";
    }

    private List<Character> compareTwoWord(String firstWord, String secondWord) {
        int firstWordLength = firstWord.length();
        int secondWordLength = secondWord.length();
        int minLength = Math.min(firstWordLength, secondWordLength);
        for (int j = 0; j < minLength; j++) {
            char firstChar = firstWord.charAt(j);
            char secondChar = secondWord.charAt(j);
            if (firstChar != secondChar) {
                return Arrays.asList(firstChar, secondChar);
            }
        }
        if (firstWordLength > secondWordLength) {
            return null;
        }
        return Arrays.asList(firstWord.charAt(0), secondWord.charAt(0));
    }
}
