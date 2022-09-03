package com.leetcode.solution.backtracking.restoreIpAddresses.second;

import com.leetcode.solution.backtracking.restoreIpAddresses.RestoreIpAddressesTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses extends RestoreIpAddressesTemplate {
    @Override
    public List<String> restoreIpAddresses(String s) {
        // Ideas: backtracking => 排列问题
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => void helper(List<String> result, List<String> list, String s, int position)
        // 4. 递归何时退出 => position >= s.length
        // 5. 单一解何时加入解集 => position >= s.length
        // 6. 剪枝
        // 		1. ip range => 1 * 4 <= ip <= 3 * 4 => 1 * (4 - list.size()) <= s.length() - position <= 3 * (4 - list.size())
        // 		2. 记忆化搜索
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (s == null || 1 * 4 > s.length() || s.length() > 3 * 4) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<String> list = new ArrayList<>();
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int position) {
        // 递归何时退出
        if (position >= s.length()) {
            result.add(String.join(".", list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < s.length() && i - position < 3; i++) {
            String substring = s.substring(position, i + 1);
            if (!isValidIpPart(substring) || (1 * (4 - list.size()) > s.length() - i) || (s.length() - i > 3 * (4 - list.size()))) {
                // 剪枝
                break;
            }

            list.add(substring);
            helper(result, list, s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValidIpPart(String ipPart) {
        if (ipPart.charAt(0) == '0' && ipPart.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(ipPart);
        return num >= 0 && num <= 255;
    }
}
