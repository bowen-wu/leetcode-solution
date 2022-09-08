## 全排列 II

<https://leetcode.cn/problems/permutations-ii/>

### 思路

回溯法 => 找到所有方案

1. 是否需要对数据源排序 => 需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, int[] nums) `
4. 递归退出条件 => ` list.size() == nums.length `
5. 单一解加入解集条件 => ` list.size() == nums.length `
6. 如何剪枝 =>
    1. 构造节点访问数组 => 访问过为 true，没访问过是 false
    2. 剪枝1 => for loop 时如果该元素访问过则跳过
    3. 剪枝2 => 如果该元素和前一个元素相同并且前一个元素 visited == false
       ![剪枝2](https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/backtracking/permutationsII/%E5%89%AA%E6%9E%9D2.png)
7. 如何分解子问题到下一层 => for loop
8. 如何回溯 => 删除单一解的最后一个元素

### 总结

| 问题行数    | 错误点                                                                                       | 正确写法                                                                              | 错误原因                                 |
|---------|-------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|--------------------------------------|
| 24      | boolean[] visited = new int[nums.length];                                                 | boolean[] visited = new boolean[nums.length];                                     | 类型写错。大意                              |
| 47 & 50 | -                                                                                         | visited[i] = true; & visited[i] = false                                           | 忘记更新 visited。思路问题                    |
| 41      | if ((i > 0 && nums[i - 1] == nums[i] && !visited[i]) &#124;&#124; list.contains(nums[i])) | if ((i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) &#124;&#124; visited[i]) | 1. 是否包含应该使用是否访问过，2. 应该查看前一个是否访问。剪枝思路 |

1. 剪枝
    1. currentValue == prevValue && !visited[prev] => 现在的值和前一个值相同 && 前一个位置没有访问过
    2. visited[i] => 这个位置上的元素访问过

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Ideas: backtracking => 排列问题
        // 1. 是否需要排序 => 需要 => 解决重复问题
        // 2. 是否需要元素位置索引 => 不需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int[] nums)
        // 4. 递归何时退出 => list.size() == nums.length
        // 5. 单一解何时加入解集 => list.size() == nums.length
        // 6. 剪枝 => visited[]
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Sort => 解决重复问题
        Arrays.sort(nums);

        // i 位置代表当前位置是否被访问过
        boolean[] visited = new boolean[nums.length];

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        // 递归何时退出 + 单一解加入解集中 => deep copy
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) || visited[i]) {
                // 剪枝
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            helper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
```
