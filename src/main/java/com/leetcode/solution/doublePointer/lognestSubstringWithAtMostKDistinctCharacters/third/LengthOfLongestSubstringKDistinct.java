package com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters.third;

import com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters.LengthOfLongestSubstringKDistinctTemplate;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct extends LengthOfLongestSubstringKDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // check input
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < k || (map.size() == k && map.containsKey(ch))) {
                    map.merge(ch, 1, Integer::sum);
                    j++;
                } else {
                    break;
                }
            }

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
