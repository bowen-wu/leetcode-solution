package com.leetcode.solution.hashTable.integerToRoman.second;

import com.leetcode.solution.hashTable.integerToRoman.IntToRomanTemplate;

public class IntToRoman extends IntToRomanTemplate {
    @Override
    public String intToRoman(int num) {
        // check input
        if (num <= 0) {
            return "";
        }

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ) {
            if (num >= nums[i]) {
                sb.append(strs[i]);
                num -= nums[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
