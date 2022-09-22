package com.leetcode.solution.hashTable.romanToInteger.first;

import com.leetcode.solution.hashTable.romanToInteger.RomanToIntTemplate;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt extends RomanToIntTemplate {
    @Override
    public int romanToInt(String s) {
        // check input
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // 如果后一个字符 > 前一个字符 则减
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = map.get(s.charAt(i));
            if (i < s.length() - 1 && (currentValue < map.get(s.charAt(i + 1)))) {
                result += (map.get(s.charAt(i + 1)) - currentValue);
                i++;
            } else {
                result += currentValue;
            }
        }
        return result;
    }
}
