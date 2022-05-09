package com.leetcode.solution;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/di-string-match/
 * 942. 增减字符串匹配
 */
public class DiStringMatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiStringMatch().diStringMatch("DDI")));
    }

    public int[] diStringMatch(String s) {
        int length = s.length();
        int minValue = 0;
        int maxValue = length;
        int[] result = new int[length + 1];

        for (int i = 0; i < length; i++) {
            if ('I' == s.charAt(i)) {
                // 升序
                result[i] = minValue;
                minValue++;
            } else {
                // 倒序
                result[i] = maxValue;
                maxValue--;
            }
        }
        result[length] = minValue;
        return result;
    }
}
