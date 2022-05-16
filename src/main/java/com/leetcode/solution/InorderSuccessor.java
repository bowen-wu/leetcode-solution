package com.leetcode.solution;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/successor-lcci/
 * 面试题 04.06. 后继者
 */
public class InorderSuccessor {
    public static void main(String[] args) {
        TreeNode threeOne = new TreeNode(1);
        TreeNode threeTwo = new TreeNode(6);
        threeTwo.left = new TreeNode(4);
        threeTwo.right = new TreeNode(7);
        TreeNode threeThree = new TreeNode(14);
        TreeNode twoOne = new TreeNode(3);
        twoOne.left = threeOne;
        twoOne.right = threeTwo;
        TreeNode twoTwo = new TreeNode(10);
        twoTwo.right = threeThree;
        TreeNode root = new TreeNode(8);
        root.left = twoOne;
        root.right = twoTwo;

        TreeNode recursion = new InorderSuccessor().inorderSuccessor(root, twoOne);
        System.out.println(recursion);
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 当前节点为 null
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (prev != null && prev.val == p.val) {
                    return pop;
                }
                prev = pop;
                node = pop.right;
            }
        }
        return null;
    }
}


