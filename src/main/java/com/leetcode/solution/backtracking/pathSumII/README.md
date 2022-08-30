## 路径总和 II

<https://leetcode.cn/problems/path-sum-ii/>

### 思路

回溯法 => 组合问题 => 所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, TreeNode node, int target) ` -> target
   逐步递减
4. 递归何时退出 => node is leaf
5. 单一解何时加入解集 => node is leaf && target == 0
6. 剪枝 => target < 0
7. 递归分解子问题到下一层 => node.left + node.right
8. 如何回溯 => 单一解删除最后一个元素

### 总结

| 问题行数 | 错误点              | 正确写法                              | 错误原因      |
|------|------------------|-----------------------------------|-----------|
| 32   | result.add(list) | result.add(new ArrayList<>(list)) | Deep Copy |

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, TreeNode node, int target) ` -> target 逐步递减
        // 4. 递归何时退出 => node is leaf
        // 5. 单一解何时加入解集 => node is leaf && target == 0
        // 6. 剪枝 => target < 0 => target 可能小于0 => 无法剪枝
        // 7. 递归分解子问题到下一层 => node.left + node.right
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (root == null) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, root, targetSum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum) {
        list.add(root.val);
        targetSum -= root.val;

        // 递归何时退出
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // 递归分解子问题到下一层
        if (root.left != null) {
            helper(result, list, root.left, targetSum);

            // 如何回溯
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helper(result, list, root.right, targetSum);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
```
