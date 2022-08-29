package com.leetcode.solution.backtracking.binaryTreePaths.first;

import com.leetcode.solution.backtracking.binaryTreePaths.BinaryTreePathsTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths extends BinaryTreePathsTemplate {
    public static void main(String[] args) {
        System.out.println(new BinaryTreePaths().binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }

    @Override
    public List<String> binaryTreePaths(TreeNode root) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => ` void helper(List<String> result, List<String> list, TreeNode node) `
        // 4. 递归退出条件 => node is leaf
        // 5. 单一解何时加入解集 => node is leaf
        // 6. 剪枝 => 无
        // 7. 递归分解子问题到下一层 =>
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<String> list = new ArrayList<>();
        helper(result, list, root);
        return result;
    }


    private void helper(List<String> result, List<String> list, TreeNode node) {
        list.add(String.valueOf(node.val));

        // 递归如何退出 + 单一解加入解集中 => node is left
        if (node.left == null && node.right == null) {
            result.add(String.join("->", list));
            return;
        }

        // 递归分解子问题到下一层
        if (node.left != null) {
            helper(result, list, node.left);

            // 如何回溯
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            helper(result, list, node.right);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }

//    private void helper(List<String> result, List<String> list, TreeNode node) {
//        // 递归如何退出 + 单一解加入解集中 => node is left
//        if (node.left == null && node.right == null) {
//            result.add(String.join("->", list));
//            return;
//        }
//
//        // 递归分解子问题到下一层
//        if (node.left != null) {
//            list.add(String.valueOf(node.left.val));
//            helper(result, list, node.left);
//
//            // 如何回溯
//            list.remove(list.size() - 1);
//        }
//
//        if (node.right != null) {
//            list.add(String.valueOf(node.right.val));
//            helper(result, list, node.right);
//
//            // 如何回溯
//            list.remove(list.size() - 1);
//        }
//    }
}
