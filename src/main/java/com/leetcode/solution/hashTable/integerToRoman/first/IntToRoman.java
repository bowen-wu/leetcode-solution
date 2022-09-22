package com.leetcode.solution.hashTable.integerToRoman.first;

import com.leetcode.solution.hashTable.integerToRoman.IntToRomanTemplate;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman extends IntToRomanTemplate {
    @Override
    public String intToRoman(int num) {
        // check input
        if (num < 1) {
            return null;
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder stringBuffer = new StringBuilder();
        int remain = num;
        for (int currentNum : nums) {
            int size = remain / currentNum;
            for (int j = 0; j < size; j++) {
                stringBuffer.append(map.get(currentNum));
            }
            remain -= currentNum * size;
        }

        return stringBuffer.toString();
    }

    public String intToRomanWithArray(int num) {
        // check input
        if (num < 1) {
            return null;
        }

        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder stringBuffer = new StringBuilder();
        int remain = num;
        for (int i = 0; i < 13; i++) {
            while (remain >= nums[i]) {
                remain -= nums[i];
                stringBuffer.append(romans[i]);
            }
        }

        return stringBuffer.toString();
    }
}
