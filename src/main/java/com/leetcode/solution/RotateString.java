package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/rotate-string/
 * 796. 旋转字符串
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "abced"));
    }

    /**
     * 时间复杂度
     * 空间复杂度
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * TODO: KMP 算法
     * 检查 goal 是否是 s+s 的子串
     */
}
