package com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters.second;

import com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters.LengthOfLongestSubstringKDistinctTemplate;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct extends LengthOfLongestSubstringKDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < k || (map.size() == k && map.containsKey(ch))) {
                    j++;
                    result = Math.max(result, j - i);
                    map.merge(ch, 1, Integer::sum);
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
