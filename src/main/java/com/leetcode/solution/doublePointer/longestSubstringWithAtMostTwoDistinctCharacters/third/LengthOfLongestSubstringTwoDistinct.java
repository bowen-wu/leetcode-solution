package com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.third;

import com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.LengthOfLongestSubstringTwoDistinctTemplate;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct extends LengthOfLongestSubstringTwoDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                // 扩展 => 1. map 的 size < 2   2. map 的 size == 2 && char 在 map 中
                char ch = s.charAt(j);
                if (map.size() < 2 || (map.size() == 2 && map.containsKey(ch))) {
                    map.merge(ch, 1, Integer::sum);
                    j++;
                } else {
                    break;
                }
            }

            // 收窄
            result = Math.max(result, j - i);
            char removeCh = s.charAt(i);
            if (map.get(removeCh) == 1) {
                map.remove(removeCh);
            } else {
                map.merge(removeCh, -1, Integer::sum);
            }
        }

        return result;

    }
}
