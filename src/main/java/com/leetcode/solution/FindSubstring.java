package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubstring {
    public static void main(String[] args) {
//        System.out.println(new FindSubstring().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}));
//        System.out.println(new FindSubstring().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new FindSubstring().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int windowLength = wordLength * words.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - windowLength; i++) {
            String str = s.substring(i, i + windowLength);
            List<String> targetList = new ArrayList<>(Arrays.asList(words));
            boolean isEqual = true;
            for (int j = 0; j <= str.length() - wordLength; ) {
                String word = str.substring(j, j + wordLength);
                if (targetList.contains(word)) {
                    targetList.remove(word);
                } else {
                    isEqual = false;
                    break;
                }
                j += wordLength;
            }
            if (isEqual) {
                result.add(i);
            }
        }
        return result;
    }
}
