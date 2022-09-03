package com.leetcode.solution.backtracking.sumRootToLeafNumbers.second;

import com.leetcode.solution.backtracking.sumRootToLeafNumbers.SumNumbersTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

public class SumNumbers extends SumNumbersTemplate {
    @Override
    public int sumNumbers(TreeNode root) {
        // Ideas: backtracking
        // 1. is need sort => no
        // 2. is need element index => no
        // 3. helper => int helper(List<Integer> list, TreeNode node)
        // 4. when exit recursion => node is leaf
        // 5. when single result add to solution set => node is leaf
        // 6. pruning
        // 7. recursive decomposition sub problems to next level => left + right
        // 8. how to backtrack => single result delete last element
        // check input
        if (root == null) {
            return 0;
        }

        // single result
        StringBuffer stringBuffer = new StringBuffer();
        return helper(stringBuffer, root);
    }

    private int helper(StringBuffer stringBuffer, TreeNode node) {
        stringBuffer.append(node.val);

        // exit recursion + single result add to solution set
        if (node.left == null && node.right == null) {
            return Integer.parseInt(stringBuffer.toString());
        }

        // result
        int result = 0;

        if (node.left != null) {
            result += helper(stringBuffer, node.left);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (node.right != null) {
            result += helper(stringBuffer, node.right);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        return result;
    }
}
