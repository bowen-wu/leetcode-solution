package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/goat-latin/
 * 824. 山羊拉丁文
 */
public class ToGoatLatin {
    public static void main(String[] args) {
        System.out.println(new ToGoatLatin().toGoatLatin("I speak Goat Latin"));
    }

    // 时间复杂度：O(n * n)
    // 空间复杂度：O(n)
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean isWordFistChar = true;
        char wordFirstChar = 0;
        int wordNumber = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) != ' ') {
                if (isWordFistChar) {
                    wordFirstChar = sentence.charAt(i);
                } else {
                    word.append(sentence.charAt(i));
                }

                isWordFistChar = false;
            }

            if (sentence.charAt(i) == ' ' || i == sentence.length() - 1) {
                // 空格 或 最后一个单词
                if (vowels.contains(wordFirstChar)) {
                    result.append(wordFirstChar).append(word);
                } else {
                    result.append(word).append(wordFirstChar);
                }
                result.append("ma");

                wordNumber++;
                for (int j = 0; j < wordNumber; j++) {
                    result.append("a");
                }

                if (i != sentence.length() - 1) {
                    result.append(" ");
                }

                word = new StringBuilder();
                isWordFistChar = true;
            }
        }
        return result.toString();
    }
}
