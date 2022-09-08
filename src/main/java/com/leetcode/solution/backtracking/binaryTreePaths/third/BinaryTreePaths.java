package com.leetcode.solution.backtracking.binaryTreePaths.third;

import com.leetcode.solution.backtracking.binaryTreePaths.BinaryTreePathsTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths extends BinaryTreePathsTemplate {
    @Override
    public List<String> binaryTreePaths(TreeNode root) {
        // Ideas: backtracking
        // is need sort => no
        // is need element position index => no
        // helper => void helper(List<String> result, List<String> list, TreeNode root)
        // when exit recursion => root is leaf
        // when single result add to solution set => root is leaf
        // pruning => no
        // recusive decomposition sub problem to next level => left + right
        // how to backtrack => single result delete last element
        // solution set
        List<String> result = new ArrayList<>();

        // chekc input
        if (root == null) {
            return result;
        }

        // working with resource data
        // single result + calculate solution set => single result add to solution set
        List<String> list = new ArrayList<>();
        helper(result, list, root);
        return result;
    }

    private void helper(List<String> result, List<String> list, TreeNode root) {
        list.add(String.valueOf(root.val));

        // exit recursion + single result add to solution set
        if (root.left == null && root.right == null) {
            result.add(String.join("->", list));
            return;
        }

        if (root.left != null) {
            helper(result, list, root.left);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helper(result, list, root.right);
            list.remove(list.size() - 1);
        }
    }
}
