package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

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

    // 时间复杂度：O(n + n + n)
    // 空间复杂度：O(1)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<Integer> recursion = recursion(root);
        Integer targetVal = null;
        for (int i = 0; i < recursion.size(); i++) {
            if (recursion.get(i) == p.val && i + 1 < recursion.size()) {
                targetVal = recursion.get(i + 1);
            }
        }
        if (targetVal == null) {
            return null;
        }
        return get(root, targetVal);
    }

    private TreeNode get(TreeNode root, int target) {
        TreeNode result = null;
        if (root.left != null) {
            result = get(root.left, target);
            if (result != null) {
                return result;
            }
        }
        if (root.val == target) {
            return root;
        }
        if (root.right != null) {
            result = get(root.right, target);
        }
        return result;
    }

    private List<Integer> recursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            result.addAll(recursion(root.left));
        }
        result.add(root.val);
        if (root.right != null) {
            result.addAll(recursion(root.right));
        }
        return result;
    }
}


