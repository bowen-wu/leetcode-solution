package com.leetcode.solution.hashTable.romanToInteger.third;

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

        // map => char -> int
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
            int currentNum = map.get(s.charAt(i));
            if (i < s.length() - 1 && currentNum < map.get(s.charAt(i + 1))) {
                result -= currentNum;
            } else {
                result += currentNum;
            }
        }
        return result;
    }
}
