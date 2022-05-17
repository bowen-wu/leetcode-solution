package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 953. 验证外星语词典
 */
public class IsAlienSorted {
    public static void main(String[] args) {
        System.out.println(new IsAlienSorted().isAlienSorted(new String[]{"hello", "hell"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new IsAlienSorted().isAlienSorted(new String[]{"hello", "hello"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new IsAlienSorted().isAlienSorted(new String[]{"word", "world"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new IsAlienSorted().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    // 时间复杂度：O()
    // 空间复杂度：O()
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            if (!twoWordSorted(words[i - 1], words[i], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean twoWordSorted(String first, String second, String order) {
        int firstLength = first.length();
        int secondLength = second.length();
        for (int i = 0; i < Math.min(firstLength, secondLength); i++) {
            int currentCharIndex = order.indexOf(first.charAt(i));
            int nextCharIndex = order.indexOf(second.charAt(i));
            if (currentCharIndex == nextCharIndex) {
                if (i == Math.min(firstLength, secondLength) - 1) {
                    return firstLength <= secondLength;
                }
            } else return currentCharIndex < nextCharIndex;
        }
        return true;
    }
}
