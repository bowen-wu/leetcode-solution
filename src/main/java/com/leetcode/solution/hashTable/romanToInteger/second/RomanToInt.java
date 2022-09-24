package com.leetcode.solution.hashTable.romanToInteger.second;

import com.leetcode.solution.hashTable.romanToInteger.RomanToIntTemplate;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt extends RomanToIntTemplate {
    @Override
    public int romanToInt(String s) {
        // Ideas: 如果后一个比前一个大，那么则减去当前的
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        // map
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < s.length() - 1 && map.get(ch) < map.get(s.charAt(i + 1))) {
                result -= map.get(ch);
            } else {
                result += map.get(ch);
            }
        }

        return result;
    }
}
