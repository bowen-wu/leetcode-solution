package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/stickers-to-spell-word/
 * 691. 贴纸拼词
 */
public class MinStickers {
    public static void main(String[] args) {
        System.out.println(new MinStickers().minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }

    public int minStickers(String[] stickers, String target) {
        int result = -1;
        Map<Character, Integer> charNumberMap = new HashMap<>();
        Map<Character, Integer> charVisibleMap = new HashMap<>();

        for (int i = 0; i < target.length(); i++) {
            char currentChar = target.charAt(i);
            charNumberMap.merge(currentChar, 1, Integer::sum);
            charVisibleMap.merge(currentChar, 1, Integer::sum);
        }

        List<String> candidateList = new ArrayList<>();
        for (int i = 0; i < stickers.length; i++) {
            String currentStr = stickers[i];
            StringBuilder newStr = new StringBuilder();
            for (int j = 0; j < currentStr.length(); j++) {
                char currentChar = currentStr.charAt(j);
                if (charVisibleMap.get(currentChar) != null) {
                    charVisibleMap.remove(currentChar);
                }
                if (charNumberMap.get(currentChar) != null) {
                    newStr.append(currentChar);
                }
            }
            if (newStr.length() > 0) {
                candidateList.add(newStr.toString());
            }
        }

        if (charVisibleMap.size() > 0) {
            // 有的字符在 stickers 中不存在
            return -1;
        }
        get(target, candidateList, charNumberMap);
        return result;
    }

    private void get(String target, List<String> candidateList, Map<Character, Integer> charNumberMap) {
        int maxMatchCharNumber = 0;
        for (int i = 0; i < candidateList.size(); i++) {
            String currentStr = candidateList.get(i);
            int currentStrMatchCharNumber = 0;
            for (int j = 0; j < currentStr.length(); j++) {
                char currentChar = currentStr.charAt(j);
                Integer times = charNumberMap.get(currentChar);
                if (times > 0) {
                    charNumberMap.put(currentChar, times - 1);
                    currentStrMatchCharNumber++;
                }
            }
            maxMatchCharNumber = Math.max(currentStrMatchCharNumber, maxMatchCharNumber);
        }
        System.out.println(maxMatchCharNumber);
    }
}
