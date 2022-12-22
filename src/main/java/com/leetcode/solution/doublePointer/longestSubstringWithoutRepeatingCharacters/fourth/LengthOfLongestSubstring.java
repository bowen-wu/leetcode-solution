package com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.fourth;

import com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.LengthOfLongestSubstringTemplate;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring extends LengthOfLongestSubstringTemplate {
    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int j = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            while (j < len) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    j++;
                } else {
                    break;
                }
            }

            // update & 收窄
            if (result < j - i) {
                result = j - i;
            }
            set.remove(s.charAt(i));
        }

        return result;
    }
}
