package com.leetcode.solution.hashTable.groupAnagrams.second;

import com.leetcode.solution.hashTable.groupAnagrams.GroupAnagramsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams extends GroupAnagramsTemplate {
    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        // Ideas: 1. 字母序 2. 出现次数 => a2b1c3
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => a2b1c3 -> List<String>
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            List<String> list = map.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            map.put(newStr, list);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsWithOccurrences(String[] strs) {
        // Ideas: 1. 字母序 2. 出现次数 => a2b1c3
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => a2b1c3 -> List<String>
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            int[] visited = new int[26];
            for (int i = 0; i < str.length(); i++) {
                visited[str.charAt(i) - 'a'] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if (visited[i] != 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(visited[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
        }

        return new ArrayList<>(map.values());
    }
}
