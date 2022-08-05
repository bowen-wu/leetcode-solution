package com.leetcode.solution.array.reverseString.second;

import com.leetcode.solution.array.reverseString.ReverseStringTemplate;

public class ReverseString extends ReverseStringTemplate {
    @Override
    public void reverseString(char[] s) {
        // 问题1： 什么类型的数组 => 字符数组
        // 问题2：是否有重复字符 => 有
        // 问题3：是否有序 => 不 care
        // 问题4：如何输出 => 原地修改输入数组
        // 问题5：函数定义
        // 问题6: 检查输入参数
        // 思路：根据 index 交换数组中的两个值。遍历从 0 -> s.length/2
        //       之后交换 i 和 s.length - 1 - i 两个值
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        if (s == null || s.length == 0) {
            return;
        }

        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private void swap(char[] chars, int first, int second) {
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
    }
}
