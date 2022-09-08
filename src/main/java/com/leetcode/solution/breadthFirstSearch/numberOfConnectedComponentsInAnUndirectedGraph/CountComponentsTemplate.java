package com.leetcode.solution.breadthFirstSearch.numberOfConnectedComponentsInAnUndirectedGraph;

/**
 * https://leetcode.cn/problems/number-of-connected-components-in-an-undirected-graph/
 * 323. 无向图中连通分量的数目
 * 你有一个包含n 个节点的图。给定一个整数 n 和一个数组edges，其中edges[i] = [ai, bi]表示图中ai和bi之间有一条边。
 * 返回 图中已连接分量的数目。
 * <p>
 * 示例 1:
 * 输入: n = 5, edges = [[0, 1], [1, 2], [3, 4]]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: n = 5, edges = [[0,1], [1,2], [2,3], [3,4]]
 * 输出: 1
 */
abstract public class CountComponentsTemplate {
    abstract public int countComponents(int n, int[][] edges);
}
