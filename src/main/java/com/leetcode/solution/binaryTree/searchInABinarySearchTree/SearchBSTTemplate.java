package com.leetcode.solution.binaryTree.searchInABinarySearchTree;

import com.leetcode.solution.binaryTree.TreeNode;

/**
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 * <p>
 * 示例 1:
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 * 示例 2:
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 */
abstract public class SearchBSTTemplate {
    abstract public TreeNode searchBST(TreeNode root, int val);
}
