package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/find-closest-lcci/
 * 面试题 17.11. 单词距离
 */
public class FindClosest {
    public static void main(String[] args) {
        System.out.println(new FindClosest().findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int word1Index = -1;
        int word2Index = -1;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (currentWord.equals(word1)) {
                word1Index = i;
                if (word2Index != -1) {
                    minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
                }
            }
            if (currentWord.equals(word2)) {
                word2Index = i;
                if (word1Index != -1) {
                    minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
                }
            }
        }
        return minDistance;
    }
}
