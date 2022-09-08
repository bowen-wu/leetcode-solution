## 二叉树的所有路径

<https://leetcode.cn/problems/binary-tree-paths/>

### 思路

回溯 => 排列问题 => 所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<String> result, List<String> list, TreeNode node) `
4. 递归退出条件 => node is leaf
5. 单一解何时加入解集 => node is leaf
6. 剪枝 => 无
7. 递归分解子问题到下一层 =>
8. 如何回溯 => 单一解删除最后一个元素

#### 优化

1. helper 函数刚刚进入的时候就把 node.val 加入到单一解中

### 总结

| 问题行数 | 错误点                 | 正确写法                                | 错误原因 |
|------|---------------------|-------------------------------------|------|
| 28   | list.add(root.val); | list.add(String.valueOf(root.val)); | 大意   |

```java
class Solution {
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
```
