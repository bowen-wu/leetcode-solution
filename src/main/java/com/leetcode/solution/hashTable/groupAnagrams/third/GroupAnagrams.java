package com.leetcode.solution.hashTable.groupAnagrams.third;

import com.leetcode.solution.hashTable.groupAnagrams.GroupAnagramsTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams extends GroupAnagramsTemplate {
    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        // Ideas: 出现次数
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => a1b2c1 -> List<String>
        Map<String, List<String>> map = new HashMap<>();
        int[] nums = new int[26];
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(nums[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
            Arrays.fill(nums, 0);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsWithOrder(String[] strs) {
        // Ideas: 字母序
        // check input
        if (strs == null || strs.length == 0) {
            return null;
        }

        // map => 字母序 -> List<String>;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String strOrder = getOrder(str);
            List<String> list = map.getOrDefault(strOrder, new ArrayList<>());
            list.add(str);
            map.put(strOrder, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getOrder(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
