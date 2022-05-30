package com.leetcode.solution;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 * 1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        System.out.println(new SumRootToLeaf().sumRootToLeaf(Codec.getTreeNode()));
    }

    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        boolean isLeaf = false;
        TreeNode currentNode = root;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (!treeNodeStack.isEmpty() || currentNode != null) {
            if (currentNode != null && currentNode.left == null && currentNode.right == null) {
                isLeaf = true;
            }
            while (currentNode != null) {
                // 左节点
                treeNodeStack.push(currentNode);
                currentNode = currentNode.left;
                if (currentNode != null && currentNode.left == null && currentNode.right == null) {
                    isLeaf = true;
                }
            }

            TreeNode peek = treeNodeStack.peek();
            if (peek.right == null) {
                int lastValue = treeNodeStack.pop().val;
                if (isLeaf) {
                    StringBuilder stringBuilder = new StringBuilder();
                    treeNodeStack.forEach(item -> stringBuilder.append(item.val));
                    result += Integer.parseInt(stringBuilder.toString() + lastValue, 2);
                }
            } else {
                currentNode = peek.right;
                peek.right = null;
            }
            isLeaf = false;
        }
        return result;
    }
}
