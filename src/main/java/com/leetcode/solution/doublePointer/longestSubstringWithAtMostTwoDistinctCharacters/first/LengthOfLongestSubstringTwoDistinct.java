package com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.first;

import com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.LengthOfLongestSubstringTwoDistinctTemplate;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct extends LengthOfLongestSubstringTwoDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // map => char -> last index
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        // double pointer
        int i = 0;
        int j = 0;

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < 2 || map.containsKey(ch)) {
                    map.put(ch, j);
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }

            // update i
            int minIndex = s.length() - 1;
            for (int index : map.values()) {
                minIndex = Math.min(minIndex, index);
            }
            map.remove(s.charAt(minIndex));
            i = minIndex;
        }

        return result;
    }
}
