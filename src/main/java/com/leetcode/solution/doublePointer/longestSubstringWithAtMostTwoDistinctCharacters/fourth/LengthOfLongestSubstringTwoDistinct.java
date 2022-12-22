package com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.fourth;

import com.leetcode.solution.doublePointer.longestSubstringWithAtMostTwoDistinctCharacters.LengthOfLongestSubstringTwoDistinctTemplate;

import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct extends LengthOfLongestSubstringTwoDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int j = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            while (j < len) {
                char ch = s.charAt(j);
                if (map.containsKey(ch) || map.size() < 2) {
                    map.merge(ch, 1, Integer::sum);
                    j++;
                } else {
                    break;
                }
            }

            if (result < j - i) {
                result = j - i;
            }

            char removeCh = s.charAt(i);
            int num = map.get(removeCh) - 1;
            if (num == 0) {
                map.remove(removeCh);
            } else {
                map.merge(removeCh, -1, Integer::sum);
            }
        }

        return result;
    }
}
