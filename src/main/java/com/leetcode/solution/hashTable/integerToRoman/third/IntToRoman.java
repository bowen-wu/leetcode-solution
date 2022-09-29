package com.leetcode.solution.hashTable.integerToRoman.third;

import com.leetcode.solution.hashTable.integerToRoman.IntToRomanTemplate;

public class IntToRoman extends IntToRomanTemplate {
    @Override
    public String intToRoman(int num) {
        // check input
        if (num < 1) {
            return null;
        }
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }
}
