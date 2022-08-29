package com.leetcode.solution.backtracking.restoreIpAddresses.first;

import com.leetcode.solution.backtracking.restoreIpAddresses.RestoreIpAddressesTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses extends RestoreIpAddressesTemplate {
    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("25525511135"));
    }

    @Override
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        // check input
        if (s == null || s.length() < 4 || s.length() > 4 * 3) {
            return result;
        }

        // 单一解
        List<String> list = new ArrayList<>();

        // 计算解集 => 单一解如何加入到解集中
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int position) {
        // 递归何时退出 + 单一解何时加入解集
        if (list.size() == 4) {
            if (position != s.length()) {
                return;
            }
            result.add(String.join(".", list));
        }

        // 分解子问题到下一层
        for (int i = position; i < s.length() && i < position + 3; i++) {
            String str = s.substring(position, i + 1);
            if ((i - position >= 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
                // 01 322
                break;
            }

            list.add(str);
            helper(result, list, s, i + 1);

            // 回溯
            list.remove(list.size() - 1);
        }
    }

    public List<String> restoreIpAddressesNoPosition(String s) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, String s) `
        // 4. 单一解 => list.add(s.subString(len))
        // 5. 递归何时退出 => s.length == 0
        // 6. 单一解何时加入解集 => s.length == 0 && list.size() == 4
        // 7. 剪枝 => s 逐步递减
        //     1. len > s.length()
        //     2. len > 1 && s.subString(0, len).startWith("0")
        //     3. Integer.parseInt(s.subString(0, len)) > 255
        //     4. 至多 => s.length() > 3 * (4 - list.size())
        //     5. 至少 => s.length() < 1 * (4 - list.size())
        // 8. 如何分解子问题到下一层 => for (int len = 1; len < 4; i++)
        // 9. 如何回溯 => 删除单一解的最后一个元素
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (s == null || s.length() < 4 || s.length() > 4 * 3) {
            return result;
        }

        // 单一解
        List<String> list = new ArrayList<>();

        // 计算解集 => 单一解如何加入到解集中
        helper(result, list, s);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s) {
        // 递归何时退出 + 单一解何时加入解集
        if (s.length() == 0) {
            if (list.size() == 4) {
                result.add(String.join(".", list));
            }
            return;
        }

        // 剪枝
        if (s.length() > 3 * (4 - list.size()) || s.length() < 1 * (4 - list.size())) {
            return;
        }

        // 分解子问题到下一层
        for (int len = 1; len < 4; len++) {
            // 剪枝
            if (len > s.length()) {
                break;
            }
            String str = s.substring(0, len);
            if ((len > 1 && str.startsWith("0")) || Integer.parseInt(str) > 255) {
                // 01 322
                break;
            }

            list.add(str);
            helper(result, list, s.substring(len));

            // 回溯
            list.remove(list.size() - 1);
        }
    }
}
