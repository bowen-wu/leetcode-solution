## 概述

- 树 => 一种无向图，其中**任意两个顶点间存在唯一一条路径**
    1. 只要没有回路的连通图就是树
    2. 一个数据结构，由节点、顶点和边组成，**没有任何环**
    3. 边 == 节点数 - 1 => 无环
- 树的分类
    1. 二叉树
        1. BST => AVL + 红黑树
    2. 字典树 Trie
    3. B树
- 根节点 + 叶子节点(Leaf) + 父亲节点 + 孩子节点 + 祖先节点
- 高度h => 叶子节点到根节点的距离。**叶子节点高度为1**，节点高度是孩子节点高度最大值 + 1 => 自底向上
- 深度d => 根节点到叶子节点的距离。**根节点深度为0** => 对于树中相同深度的每个节点来说，它们的高度不一定相同 => 自顶向下
- 层 => 深度相同的节点处于同一层

## 二叉树

- 二叉树 => 树中节点的度不大于2的有序树
- 树节点的度数即为该节点孩子的个数
- 每个节点最多可以有两个孩子节点

```java
public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T rootData) {
        val = rootData;
    }
}
```

### 满二叉树

- 一颗二叉树只有度为0的节点和度为2的节点，并且度为0的节点在同一层
- 除最后一层无任何子节点外，每一层上的所有节点都有两个子节点
- 最后一层上的节点为叶子节点
- 深度为k的二叉树有2<sup>k+1</sup>-1个节点（定义根节点所在深度 k<sub>0</sub>=0）

### 完全二叉树

- 在一颗二叉树中，若除最后一层外的其余层都是满的，并且最后一层要么是满的，要么在右边缺少连续若干节点，则此二叉树为完全二叉树
- 一颗深度为k的有n个节点的二叉树，对树中的节点按从上至下、从左到右的顺序进行编号，编号为i(1 <= i <= n)的节点的位置和满二叉树中编号为i的节点位置相同
- 具有n个节点的完全二叉树的深度为 log<sub>2</sub>n + 1
- 深度为k的完全二叉树，至少有 2<sup>k - 1</sup> 个节点，至多有 2<sup>k</sup> - 1 个节点 => k<sub>根节点</sub> = 1

### 属性

- 在第i层(i从0开始)，最多有 2<sup>i</sup> 个节点
- 一个深度为k的树最多有 2<sup>k</sup> - 1 个节点 => k<sub>根节点</sub> = 1
- 一个有n个节点的满二叉树，树的高度是 log<sub>2</sub>(n + 1)
- 如果从根节点开始为节点编号，完全二叉树中对于节点编号为k的节点，其左孩子编号为 2k + 1，右孩子编号为 2k + 2

|                               | 完全二叉树                                     | 满二叉树                                 | 
|-------------------------------|-------------------------------------------|--------------------------------------|
| 深度k                           | 如果根节点深度 k<sub>根节点</sub> = 0，那么深度k = 树高h - 1   | 如果根节点深度 k<sub>根节点</sub> = 1，那么深度k = 树高h  |
| 总节点n(根节点所在深度 k<sub>0</sub>=1) | 2<sup>k-1</sup> <= n <= 2<sup>k</sup> - 1 | n = 2<sup>k</sup> - 1                |
| 树高h                           | h = log<sub>2</sub>n + 1                  | h = log<sub>2</sub>(n + 1)           |

## 二叉树遍历

### [前序遍历 根左右](https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/binaryTree/binaryTreePreorderTraversal/README.md)

### [中序遍历 左根右](https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/binaryTree/binaryTreeInorderTraversal/README.md)

### [后序遍历 左右根](https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/binaryTree/binaryTreePostorderTraversal/README.md)

## 构造二叉树

- 需要两种不同的遍历结果来构造唯一确定的二叉树，并且其中一个必须是**中序遍历**
- 后序最末根节点
- 前序最先根节点
- 中序划定左与右

## 二叉搜索树

- Binary Search Tree => BST
- 所有子树均为二叉搜索树
- 任一左子树的全部节点的值均小于其根节点的值
- 任一右子树的全部节点的值均大于其根节点的值
- 二叉搜索树的**中序遍历为一个排序数组**
- 二叉搜索树可以高效进行查找、添加和删除节点操作，时间复杂度均和树高有关。如果共有 n 个元素，平均时间复杂度O(logn)

```java
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
```

## 知识点

1. 疑问：递归遍历的时间复杂度 => 感觉是范围值，因为树的结构不知道
    1. 如果是 BST，时间复杂度为何是 O(logn)
        1. 二叉树查找的时间复杂度和高度有关，T(n) = O(h)
        2. 二叉树的高度和总节点数有关。拥有最多的节点是满 BST，此时 h = log2(n + 1)
        3. 故如果此 BST 是满 BST => T(n) = O(log2(n + 1))
        4. 如果此 BST 不是满 BST => 节点数 < 满 BST 节点数 => T(n) < O(log2(n + 1))
        5. 根据时间复杂度计算原则 => T(n) <= O(logn) => 取最大值 T(n) = O(logn)
    2. 如果不是 BST，那么是 O(n)
2. 树问题思路 => 递归较迭代更加容易，先想递归再想迭代
    1. 递归
    2. 迭代
