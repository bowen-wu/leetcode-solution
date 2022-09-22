package com.leetcode.solution.hashTable.wordPattern.first;

import com.leetcode.solution.hashTable.wordPattern.WordPatternTemplate;

import java.util.HashMap;
import java.util.Map;

public class WordPattern extends WordPatternTemplate {
    @Override
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0) {
            return false;
        }

        // map => char -> String
        Map<Character, String> map = new HashMap<>();
        StringBuilder stringBuffer = new StringBuilder();
        int position = 0;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            while (position < s.length() && s.charAt(position) != ' ') {
                stringBuffer.append(s.charAt(position++));
            }
            String str = stringBuffer.toString();

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(str)) {
                    return false;
                }
            } else if (map.containsValue(str)) {
                return false;
            } else {
                map.put(ch, str);
            }

            position++;
            stringBuffer = new StringBuilder();
        }
        return position == s.length() + 1;
    }


    public boolean wordPatternWithArray(String pattern, String s) {
        // check input
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0) {
            return false;
        }

        // map => ch -> word
        Map<Character, String> map = new HashMap<>();
        String[] strArray = s.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strArray[i])) {
                    return false;
                }
            } else if (map.containsValue(strArray[i])) {
                return false;
            } else {
                map.put(pattern.charAt(i), strArray[i]);
            }
        }
        return true;
    }
}
