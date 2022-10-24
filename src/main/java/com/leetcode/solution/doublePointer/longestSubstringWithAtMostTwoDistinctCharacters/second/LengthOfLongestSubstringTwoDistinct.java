package com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.second;

import com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.LengthOfLongestSubstringTwoDistinctTemplate;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct extends LengthOfLongestSubstringTwoDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // check input
        if (s == null && s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < 2 || (map.size() == 2 && map.containsKey(ch))) {
                    // extends
                    j++;
                    map.merge(ch, 1, Integer::sum);
                    result = Math.max(result, j - i);
                } else {
                    break;
                }
            }

            // 收窄
            char ch = s.charAt(i);
            int newFrequency = map.get(ch) - 1;
            if (newFrequency == 0) {
                map.remove(ch);
            } else {
                map.put(ch, newFrequency);
            }
        }
        return result;
    }
}
