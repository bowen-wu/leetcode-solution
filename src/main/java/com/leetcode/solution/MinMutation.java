package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 433. 最小基因变化
 */
public class MinMutation {
    public static void main(String[] args) {
        System.out.println(new MinMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"})); // 2
        System.out.println(new MinMutation().minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"})); // -1
        System.out.println(new MinMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"})); // 4
    }

    // 时间复杂度：O() ?
    // 空间复杂度：O() ?
    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }

        return mutationTime(start, end, Arrays.asList(bank));
    }

    public int mutationTime(String start, String end, List<String> bank) {
        int result = -1;
        for (int i = 0; i < bank.size(); i++) {
            String current = bank.get(i);
            // 判断是否和 start 仅仅 mutation 一次
            boolean oneTimeMutation = false;
            for (int j = 0; j < start.length(); j++) {
                if (start.charAt(j) != current.charAt(j)) {
                    if (oneTimeMutation) {
                        // mutation 2次
                        oneTimeMutation = false;
                        break;
                    } else {
                        oneTimeMutation = true;
                    }
                }
            }
            if (oneTimeMutation) {
                if (current.equals(end)) {
                    return 1;
                }
                List<String> nextBank = new ArrayList<>(bank);
                nextBank.remove(current);
                int nextResult = mutationTime(current, end, nextBank);
                result = 1;
                if (nextResult == -1) {
                    result = -1;
                } else {
                    result += nextResult;
                }
            }
        }

        return result;
    }
}
