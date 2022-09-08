## 组合总和 II

<https://leetcode.cn/problems/combination-sum-ii/>

### 思路

回溯法 => 找子集 => 组合问题

1. 是否需要排序 => 需要
2. 是否需要元素位置索引 => 需要
3. helper 函数定义 => ` void helper(List<List<Integer> result, List<Integer> list, int[] nums, int position, int target) `
4. 递归退出条件 => position >= nums.length
5. 单一解何时加入解集 => target == 0
6. 剪枝 => target < 0 + nums[i] > target
7. 如何分解子问题到下一层 => for loop
8. 如何回溯 => 单一解移除最后一个元素
9. 优化 => target 逐步递减，便可以不用计算 list 的 sum
10. 解集不能包含重复的组合 => 当前元素和前一个元素相等则跳过

### 总结

1. 思路要**去重**

| 问题行数        | 错误点        | 正确写法       | 错误原因                                |
|-------------|------------|------------|-------------------------------------|
| 25          | candidatas | candidates | 笔误                                  |
| 46 - 48     | -          | continue;  | 本题要去重，在思路期间要考虑到                     |
| 21          | condidates | candidates | 笔误                                  |
| 第三遍 46 - 48 | -          | continue;  | 本题要去重，在思路期间要考虑到，去重不能 break，只需要跳过当前值 |

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Ideas: backtrackint => 组合问题
        // 1. 是否需要排序 => 需要 => 大小问题和重复问题
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position)
        // 4. 递归何时退出 => target < 0
        // 5. 单一解何时加入解集 => target == 0 => target 在递归的过程中逐步递减
        // 6. 剪枝
        // 7. 如何分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }

        // Sort => 解决重复和比大小问题
        Arrays.sort(candidates);

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int position) {
        // 递归何时退出 + 单一解加入解集中 => deep copy
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < candidates.length; i++) {
            if (target < candidates[i]) {
                // 剪枝
                break;
            }

            // 去重
            if (i > position && candidates[i - 1] == candidates[i]) {
                continue;
            }

            list.add(candidates[i]);
            helper(result, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
```
