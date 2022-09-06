## 删除二叉搜索树中的节点

<https://leetcode.cn/problems/delete-node-in-a-bst/>

### 思路

1. 使用递归
2. 如果 root.val > key => 则在左子树中删除该节点
3. 如果 root.val < key => 则在右子树中删除该节点
4. 如果 root.val == key
    1. root 节点是叶子节点 => null
    2. root 节点有左子树或右子树 => 用左子树或右子树代替删除节点
    3. root 节点有左右子树 => 使用左子树的最大值或者右子树的最小值代替删除节点

### 总结

1. 如果使用遍历，需要找到父节点
2. 如果左右子树都有，那么要找到左子树的最大值，之后还要找到该最大值的父节点

```java
// 错误示例：遍历法
public class DeleteNode extends DeleteNodeTemplate {
    @Override
    public TreeNode deleteNode(TreeNode root, int key) {
        // 思路：使用单指针找到 key，如果没有找到，则返回 root
        // 		如果找到，则删除，删除的节点情况分析
        //			1. 如果是叶子节点，直接删除
        // 			2. 如果只有左子树或右子树，则将左子树或右子树移动到删除节点位置
        // 			3. 如果左右子树都有，则查找左子树最大值后者右子树的最小值代替删除节点
        if (root == null) {
            return null;
        }
        if (root.val == key && root.left == null && root.right == null) {
            return null;
        }
        TreeNode nodeParent = root;
        TreeNode node = root;
        while (node != null) {
            if (node.val == key) {
                // delete node
                if (node.left == null && node.right == null) {
                    // leaf
                    if (nodeParent.val > key) {
                        nodeParent.left = null;
                    } else {
                        nodeParent.right = null;
                    }
                } else if (node.left == null || node.right == null) {
                    // only has right or left sub tree
                    TreeNode subTree = node.left == null ? node.right : node.left;
                    node.val = subTree.val;
                    node.left = subTree.left;
                    node.right = subTree.right;
                } else {
                    // has left and right sub tree
                    TreeNode maxNodeInLeft = node.left;
                    while (maxNodeInLeft.right != null) {
                        parent = maxNodeInLeft;
                        maxNodeInLeft = maxNodeInLeft.right;
                    }
                    if (nodeParent.val > key) {
                        nodeParent.left = null;
                    } else {
                        nodeParent.right = null;
                    }

                }
                return root;
            } else if (node.val > key) {
                nodeParent = node;
                node = node.left;
            } else {
                nodeParent = node;
                node = node.right;
            }
        }
        return root;
    }
}
```

| 问题行数 | 错误点                                                    | 正确写法                                                   | 错误原因                |
|------|--------------------------------------------------------|--------------------------------------------------------|---------------------|
| 12   | if (root.left == null && right.right == null)          | if (root.left == null && root.right == null)           | 笔误                  |
| 27   | deleteNode(root.left, leftMaxNode.val);                | root.left = deleteNode(root.left, maxNodeInLeft.val);  | 应该更新 root.left。思路问题 |
| 16   | if (root.left != null &#124;&#124; root.right != null) | if (root.left == null &#124;&#124; root.right == null) | 判断只有一个子树。很生气        | 

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 思路：使用递归，删除节点情况
        // 		1. 叶子节点 => return null 
        // 		2. 只有一个子树 => 直接返回这个子树
        // 		3. 有左右子树 => 找到左子树的最大值或者右子树的最小值，之后在左子树中删除最大值或在右子树中删除最小值
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                // leaf;
                return null;
            }
            if (root.left == null || root.right == null) {
                // only has one subtree
                return root.left == null ? root.right : root.left;
            }

            // has left and right subtree
            TreeNode maxNodeInLeft = root.left;
            while (maxNodeInLeft.right != null) {
                maxNodeInLeft = maxNodeInLeft.right;
            }
            root.val = maxNodeInLeft.val;
            root.left = deleteNode(root.left, maxNodeInLeft.val);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
```
