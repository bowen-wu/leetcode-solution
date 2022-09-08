package com.leetcode.solution.backtracking.sumRootToLeafNumbers.third;

import com.leetcode.solution.backtracking.sumRootToLeafNumbers.SumNumbersTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

public class SumNumbers extends SumNumbersTemplate {
    @Override
    public int sumNumbers(TreeNode root) {
        // Ideas: backtracking
        // is need working with source data => no
        // is need element position index => no
        // helper => int helper(TreeNode root)
        // when exit recursion => root is leaf
        // when single result add to solution set => no
        // pruning => no
        // recursive decomposition sub problem to next level => left + right
        // how to backtrack => single result delete last element
        if (root == null) {
            return 0;
        }

        // single result
        StringBuffer stringBuffer = new StringBuffer();
        return helper(stringBuffer, root);
    }

    private int helper(StringBuffer stringBuffer, TreeNode root) {
        stringBuffer.append(String.valueOf(root.val));

        // exit recursion
        if (root.left == null && root.right == null) {
            return Integer.parseInt(stringBuffer.toString());
        }

        // construct result
        int result = 0;

        // recursive decomposition sub problem to next level
        if (root.left != null) {
            result += helper(stringBuffer, root.left);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (root.right != null) {
            result += helper(stringBuffer, root.right);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        return result;
    }
}
