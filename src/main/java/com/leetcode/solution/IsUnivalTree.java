package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/univalued-binary-tree/
 * 965. 单值二叉树
 */
public class IsUnivalTree {
    public static void main(String[] args) {
        TreeNode threeOne = new TreeNode(1);
        TreeNode threeTwo = new TreeNode(1);
        threeTwo.left = new TreeNode(12);
        threeTwo.right = new TreeNode(1);
        TreeNode threeThree = new TreeNode(1);
        TreeNode twoOne = new TreeNode(12);
        twoOne.left = threeOne;
        twoOne.right = threeTwo;
        TreeNode twoTwo = new TreeNode(1);
        twoTwo.right = threeThree;
        TreeNode root = new TreeNode(1);
        root.left = twoOne;
        root.right = twoTwo;

        System.out.println(new IsUnivalTree().isUnivalTree(root));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode peek = queue.poll();
            if (peek.val != value) {
                return false;
            }
            if (peek.left != null) {
                queue.add(peek.left);
            }
            if (peek.right != null) {
                queue.add(peek.right);
            }
        }
        return true;
    }
}
