package com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.third;

import com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.LengthOfLongestSubstringTemplate;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring extends LengthOfLongestSubstringTemplate {
    @Override
    public int lengthOfLongestSubstring(String s) {
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    // 增加
                    set.add(ch);
                    j++;
                } else {
                    break;
                }
            }

            // 收窄 + update
            // result = Math.max(result, set.size());
            result = Math.max(result, j - i);
            set.remove(s.charAt(i));
        }

        return result;
    }
}
