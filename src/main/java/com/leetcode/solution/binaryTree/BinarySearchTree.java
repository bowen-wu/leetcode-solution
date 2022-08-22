package com.leetcode.solution.binaryTree;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public BinarySearchTree(int value) {
        this.root = new TreeNode(value);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public boolean find(int value) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        TreeNode node = root;
        while (node != null) {
            if (node.getVal() == value) {
                return true;
            } else if (node.getVal() > value) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    public boolean add(int value) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
        if (root == null) {
            setRoot(new TreeNode(value));
            return true;
        }

        TreeNode node = root;
        while (node != null) {
            if (node.getVal() == value) {
                return false;
            } else if (node.getVal() > value) {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode(value));
                    return true;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode(value));
                    return true;
                }
                node = node.getRight();
            }
        }
        return false;
    }

    private TreeNode deleteNode(TreeNode root, int value) {
        if (root.val == value) {
            // remove
            if (root.getLeft() == null && root.getRight() == null) {
                // 删除的节点是叶子节点
                return null;
            } else if (root.getLeft() == null) {
                // 删除节点的左节点是 null
                return root.getRight();
            } else if (root.getRight() == null) {
                // 删除节点的右节点是 null
                return root.getLeft();
            } else {
                // 删除节点左右子树都有
                // 查找右子树最小节点
                TreeNode rightMinNode = root.getRight();
                while (rightMinNode.getLeft() != null) {
                    rightMinNode = rightMinNode.getLeft();
                }

                // 将右子树最小值赋给删除的节点
                root.setVal(rightMinNode.getVal());

                // 删除 rightMinNode 节点
                TreeNode treeNode = deleteNode(root.getRight(), rightMinNode.getVal());
                root.setRight(treeNode);
            }
        } else if (root.getVal() > value) {
            root.setLeft(deleteNode(root.left, value));
        } else {
            root.setRight(deleteNode(root.right, value));
        }
        return root;
    }

    public TreeNode remove(int value) {
        // 1. 查找删除节点，如果有，删除
        // 2. 调整树结构，使得删除节点n后的树仍然为二叉搜索树
        //      2-1: 节点n是叶子节点 => 直接删除，使用 null 代替节点n
        //      2-2: 节点n只有一个子树(左子树或者右子树) => 使用左子树或者右子树代替节点n
        //      2-3: 节点n有两个子树 => 左子树的最右节点或者右子树的最左节点代替节点n => n 的中序遍历的后一个或前一个节点
        if (root == null) {
            return null;
        }
        return deleteNode(root, value);
    }

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}

