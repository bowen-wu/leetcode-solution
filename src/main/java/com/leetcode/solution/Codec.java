package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * 449. 序列化和反序列化二叉搜索树
 */
public class Codec {
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

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);
        System.out.println(tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        // DFS => 前序遍历 => 根节点 -> 左节点 -> 右节点
        // 数字之间使用 , 分隔
        return getValFromTreeNode(root);
    }

    private String getValFromTreeNode(TreeNode root) {
        StringBuilder result = new StringBuilder();
        result.append(root.val);
        result.append(",");
        if (root.left != null) {
            result.append(getValFromTreeNode(root.left));
        }
        if (root.right != null) {
            result.append(getValFromTreeNode(root.right));
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        List<Integer> list = Arrays.stream(data.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return getTreeNodeFromList(list);
    }

    private TreeNode getTreeNodeFromList(List<Integer> data) {
        int rootVal = data.get(0);
        TreeNode root = new TreeNode(rootVal);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            int currentVal = data.get(i);
            if (currentVal < rootVal) {
                leftList.add(currentVal);
            } else {
                rightList.add(currentVal);
            }
        }
        if (leftList.size() > 0) {
            root.left = getTreeNodeFromList(leftList);
        }
        if (rightList.size() > 0) {
            root.right = getTreeNodeFromList(rightList);
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
