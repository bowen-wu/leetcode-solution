package com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters.fourth;

import com.leetcode.solution.doublePointer.lognestSubstringWithAtMostKDistinctCharacters.LengthOfLongestSubstringKDistinctTemplate;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct extends LengthOfLongestSubstringKDistinctTemplate {
    @Override
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            while (j < len) {
                char ch = s.charAt(j);
                if (map.containsKey(ch) || map.size() < k) {
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
            if (map.get(removeCh) == 1) {
                map.remove(removeCh);
            } else {
                map.merge(removeCh, -1, Integer::sum);
            }
        }

        return result;
    }
}
