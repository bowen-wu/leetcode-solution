package com.leetcode.solution.generalQuestionsDFS.graphValidTree;

/**
 * https://leetcode.cn/problems/graph-valid-tree/
 * 261. 以图判树
 * 给定编号从 0 到 n - 1的n 个结点。给定一个整数n和一个edges列表，其中edges[i] = [ai, bi]表示图中节点ai和bi之间存在一条无向边。
 * 如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * 输出: false
 */
abstract public class ValidTreeTemplate {
    abstract public boolean validTree(int n, int[][] edges);
}
