package com.leetcode.solution;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/di-string-match/
 * 942. 增减字符串匹配
 */
public class DiStringMatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiStringMatch().diStringMatch("DDD")));
    }

    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] result = new int[length + 1];
        StringBuilder continuousD = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if ('I' == s.charAt(i)) {
                // 升序
                continuousDHandle(continuousD, i, result);
                continuousD = new StringBuilder();
                result[i + 1] = i + 1;
            } else {
                // 倒序
                continuousD.append('D');
                result[i] = i + 1;
                result[i + 1] = i;
            }
        }

        continuousDHandle(continuousD, length, result);
        return result;
    }

    private void continuousDHandle(StringBuilder continuousD, int maxIndex, int[] result) {
        int continuousDLength = continuousD.length();
        if (continuousDLength > 1) {
            // 多个 D
            int index = maxIndex;
            int minValue = maxIndex - continuousDLength;
            while (index >= maxIndex - continuousDLength) {
                result[index] = minValue;
                index--;
                minValue++;
            }
        }
    }
}
