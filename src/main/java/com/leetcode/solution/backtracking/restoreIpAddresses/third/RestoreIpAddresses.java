package com.leetcode.solution.backtracking.restoreIpAddresses.third;

import com.leetcode.solution.backtracking.restoreIpAddresses.RestoreIpAddressesTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses extends RestoreIpAddressesTemplate {
    @Override
    public List<String> restoreIpAddresses(String s) {
        // Ideas: backtracking => 排列问题
        // pruning => 1. isValidIpPart => [0, 255] & 没有前导0  2. lengthRange => [4 * 1, 4 * 3]
        // solution set
        List<String> result = new ArrayList<>();

        // check input
        if (s == null || 4 * 1 > s.length() || s.length() > 4 * 3) {
            return result;
        }

        // working with source data
        // single result + calculate solution set => single result add to solution set
        List<String> list = new ArrayList<>();
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int position) {
        // when exit recursion + single result add to solution set => list.size == 4
        if (position >= s.length()) {
            if (list.size() == 4) {
                result.add(String.join(".", list));
            }
            return;
        }

        // pruning
        if ((4 - list.size()) * 1 > s.length() - position || s.length() - position > (4 - list.size()) * 3) {
            return;
        }

        // recursive decomposition sub problem to next level + pruning
        for (int i = position; i < s.length() && (i - position < 3); i++) {
            String substring = s.substring(position, i + 1);
            if (!isValidIpPart(substring)) {
                continue;
            }

            list.add(substring);
            helper(result, list, s, i + 1);

            // how to backtrack
            list.remove(list.size() - 1);
        }
    }

    private boolean isValidIpPart(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }

        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
