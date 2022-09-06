package com.leetcode.solution.generalQuestionsDFS.numberOfProvinces.first;

import com.leetcode.solution.generalQuestionsDFS.numberOfProvinces.FindCircleNumTemplate;

public class FindCircleNum extends FindCircleNumTemplate {
    @Override
    public int findCircleNum(int[][] isConnected) {
        // Ideas: 求连通分量 => dfs 的次数
        // 时间复杂度 => O(n^2)
        // 空间复杂度 => O(n)
        if (isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }
        int count = 0;
        boolean[] marked = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!marked[i]) {
                helper(isConnected, marked, i);
                count++;
            }
        }
        return count;
    }

    private void helper(int[][] isConnected, boolean[] marked, int start) {
        marked[start] = true;

        // 此处需要判断是否连接 => isConnected[start][i] == 1
        for (int i = 0; i < isConnected[start].length; i++) {
            if (isConnected[start][i] == 1 && !marked[i]) {
                helper(isConnected, marked, i);
            }
        }
    }
}
