package com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.first;

import com.leetcode.solution.doublePointer.longestSubstringWithoutRepeatingCharacters.LengthOfLongestSubstringTemplate;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring extends LengthOfLongestSubstringTemplate {
    @Override
    public int lengthOfLongestSubstring(String s) {
        // Ideas: sliding window
        if (s == null) {
            return 0;
        }

        // map => 只需要知道字符即可
        Set<Character> set = new HashSet<>();
        int result = 0;

        // 双指针
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }

            // 收窄
            set.remove(s.charAt(i));
        }

        return result;
    }
}
