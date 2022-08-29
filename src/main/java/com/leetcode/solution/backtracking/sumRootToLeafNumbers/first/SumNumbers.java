package com.leetcode.solution.backtracking.sumRootToLeafNumbers.first;

import com.leetcode.solution.backtracking.sumRootToLeafNumbers.SumNumbersTemplate;
import com.leetcode.solution.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers extends SumNumbersTemplate {
    public static void main(String[] args) {
        System.out.println(new SumNumbers().sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }

    @Override
    public int sumNumbers(TreeNode root) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => ` void helper(int result, List<Integer> list, TreeNode node) `
        // 4. 递归何时退出 => node is leaf
        // 5. 单一解何时加入解集中 => node is leaf
        // 6. 剪枝
        // 7. 递归分解子问题到下一层 => node.left + node.right
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        int[] result = new int[1];

        // check input
        if (root == null) {
            return 0;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        StringBuffer stringBuffer = new StringBuffer();
        helper(result, stringBuffer, root);
        return result[0];
    }

    private void helper(int[] result, StringBuffer stringBuffer, TreeNode root) {
        stringBuffer.append(root.val);

        // 递归何时退出 + 单一解何时加入解集
        if (root.left == null && root.right == null) {
            result[0] += Integer.parseInt(stringBuffer.toString());
            return;
        }

        if (root.left != null) {
            helper(result, stringBuffer, root.left);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (root.right != null) {
            helper(result, stringBuffer, root.right);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
