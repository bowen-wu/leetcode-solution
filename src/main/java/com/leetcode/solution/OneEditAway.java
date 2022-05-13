package com.leetcode.solution;

/**
 * https://leetcode.cn/problems/one-away-lcci/
 * 面试题 01.05. 一次编辑
 */
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(new OneEditAway().oneEditAway("teacher", "taches"));
    }

    // 时间复杂度：O(n) => n 为两个字符串的最大长度
    // 空间复杂度：O(1)
    public boolean oneEditAway(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();

        if (firstLength == secondLength) {
            // 相等 | 替换
            boolean result = true;
            int differentNum = 0;
            for (int i = 0; i < firstLength; i++) {
                if (first.charAt(i) == second.charAt(i) || differentNum++ < 1) continue;
                result = false;
                break;
            }
            return result;
        }

        if (firstLength - 1 == secondLength) {
            // 删除
            return deleteOrAdd(second, first);
        }
        if (firstLength + 1 == secondLength) {
            // 增加
            return deleteOrAdd(first, second);
        }
        return false;
    }

    private boolean deleteOrAdd(String shortStr, String longStr) {
        boolean result = true;
        for (int i = 0, j = 0; i < shortStr.length(); i++, j++) {
            if ((shortStr.charAt(i) == longStr.charAt(j)) || (j + 1 < longStr.length() && shortStr.charAt(i) == longStr.charAt(++j) && i + 1 == j))
                continue;
            result = false;
            break;
        }
        return result;
    }
}
