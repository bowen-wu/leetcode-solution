package com.leetcode.solution.hashTable.groupAnagrams.first;

import com.leetcode.solution.hashTable.groupAnagrams.GroupAnagramsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams extends GroupAnagramsTemplate {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagramsWithNumberOfOccurrences(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => 字母序 -> List<Word>
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String alphabeticalOrder = new String(chars);
            List<String> list = map.getOrDefault(alphabeticalOrder, new ArrayList<>());
            list.add(str);
            map.put(alphabeticalOrder, list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsWithNumberOfOccurrences(String[] strs) {
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => ch + 出现次数 key -> List<Word>
        Map<String, List<String>> map = new HashMap<>();
        int[] occurrences = new int[26];

        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                occurrences[str.charAt(i) - 'a'] += 1;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < occurrences.length; i++) {
                if (occurrences[i] > 0) {
                    char ch = (char) (i + 'a');
                    stringBuilder.append(ch);
                    stringBuilder.append(occurrences[i]);
                }
            }

            String key = stringBuilder.toString();

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
            Arrays.fill(occurrences, 0);
        }
        return new ArrayList<>(map.values());
    }
}
