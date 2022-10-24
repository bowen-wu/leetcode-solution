package com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.second;

import com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.LengthOfLongestSubstringTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring extends LengthOfLongestSubstringTemplate {
    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }

            result = Math.max(result, set.size());
            set.remove(s.charAt(i));
        }
        return result;
    }

    public int lengthOfLongestSubstringWithMap(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = left;
        int result = Integer.MIN_VALUE;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                result = Math.max(result, map.size());
                int newLeft = map.get(ch) + 1;
                for (int i = left; i < newLeft; i++) {
                    map.remove(s.charAt(i));
                }
                left = newLeft;
            }
            map.put(ch, right);
            right++;
        }

        return Math.max(result, map.size());
    }
}
