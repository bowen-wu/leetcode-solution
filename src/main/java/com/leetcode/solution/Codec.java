package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

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
        String tree = ser.serialize(root); // 8LR#3LR,10R#1,6LR,14#4,7#
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        // BFS
        // 层之间使用 # 区分
        // 同一层的使用 , 区分
        // 如果有 left 则添加 L
        // 如果有 right 则添加 R
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLayerNumber = 1;
        int nextLayerNumber = 0;

        while (queue.size() > 0) {
            TreeNode remove = queue.remove();
            result.append(remove.val);

            if (remove.left != null) {
                queue.add(remove.left);
                nextLayerNumber++;
                result.append("L");
            }

            if (remove.right != null) {
                queue.add(remove.right);
                nextLayerNumber++;
                result.append("R");
            }

            currentLayerNumber--;
            if (currentLayerNumber == 0) {
                result.append('#');
                currentLayerNumber = nextLayerNumber;
                nextLayerNumber = 0;
            } else {
                result.append(',');
            }

        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        StringBuilder numberBuilder = new StringBuilder();
        int nextStrIndex = 0;
        int leftPosition = -1;
        int rightPosition = -1;

        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (currentChar >= 48 && currentChar <= 57) {
                // 数字
                numberBuilder.append(currentChar);
            }
            if (currentChar == 35) { // #
                nextStrIndex = i + 1;
                break;
            }
            if (currentChar == 76) { // L
                leftPosition = 1;
            }
            if (currentChar == 82) { // R
                rightPosition = leftPosition != -1 ? 2 : 1;
            }
        }

        TreeNode result = new TreeNode(Integer.parseInt(numberBuilder.toString()));
        recursion(result, data, nextStrIndex, leftPosition, rightPosition);
        return result;
    }

    private TreeNode recursion(TreeNode root, String data, int dataStartIndex, int leftPosition, int rightPosition) {
        int currentPosition = 0;
        int nextLayerPosition = 0;
        int childLeftPosition = -1;
        int childRightPosition = -1;
        StringBuilder numberBuilder = new StringBuilder();
        int poundIndex = data.substring(dataStartIndex).indexOf("#");

        for (int i = dataStartIndex; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (currentChar >= 48 && currentChar <= 57) {
                // 数字
                numberBuilder.append(currentChar);
            } else if (currentChar == 76) { // L
                childLeftPosition = ++nextLayerPosition;
            } else if (currentChar == 82) { // R
                childRightPosition = ++nextLayerPosition;
            } else if (currentChar == 44 || currentChar == 35) { // , #
                currentPosition++;
                TreeNode child = new TreeNode(Integer.parseInt(numberBuilder.toString()));
                if (currentPosition == leftPosition) {
                    root.left = recursion(child, data, poundIndex + dataStartIndex + 1, childLeftPosition, childRightPosition);
                }
                if (currentPosition == rightPosition) {
                    root.right = recursion(child, data, poundIndex + dataStartIndex + 1, childLeftPosition, childRightPosition);
                }

                childLeftPosition = -1;
                childRightPosition = -1;
                numberBuilder = new StringBuilder();

                if (currentChar == 35) {
                    break;
                }
            }
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
