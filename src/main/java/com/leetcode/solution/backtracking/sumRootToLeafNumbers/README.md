## 求根节点到叶节点数字之和

<https://leetcode.cn/problems/sum-root-to-leaf-numbers/>

### 思路

回溯法 => 组合问题 => 查找所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(int result, List<Integer> list, TreeNode node) `
4. 递归何时退出 => node is leaf
5. 单一解何时加入解集中 => node is leaf
6. 剪枝
7. 递归分解子问题到下一层 => node.left + node.right
8. 如何回溯 => 单一解删除最后一个元素

### 总结

1. 注意 StringBuffer 替代 List<String> => list 最终要 join 起来，并且其中没有任何连接符

| 问题行数 | 错误点                                                   | 正确写法            | 错误原因        |
|------|-------------------------------------------------------|-----------------|-------------|
| 31   | int result = Integer.parseInt(String.join("", list)); | int result = 0; | 多加了根节点的值。大意 |

```java
class Solution {
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
```
