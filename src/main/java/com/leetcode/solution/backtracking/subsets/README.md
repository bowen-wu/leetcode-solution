## 子集

<https://leetcode.cn/problems/subsets/>

### 思路

1. backtracking 模板
2. 递归何时退出 => 开始的位置大于 nums.length
3. 单一解何时加入到解集中 => 新增数据后
4. 递归分解子问题 => for loop => 初始值是开始的位置
5. 何时回溯 + 怎么回溯 => 遍历完以当前节点为开头的所有数组 + 移除最后一个元素

### 总结

| 问题行数 | 错误点                       | 正确写法                               | 错误原因                        |
|------|---------------------------|------------------------------------|-----------------------------|
| 13   | List<List<String>> result | List<List<Integer>> result         | 类型写错，应该是 Integer。大意         |
| 21   | List<String> list         | List<Integer> list                 | 类型写错，应该是 Integer。大意         |
| 28   | result.add(list)          | result.add(new ArrayList<>(list)); | 单一解加入解集时注意**Deep Copy**。注意点 |
| 36   | int i = 0                 | int i = position                   | 初始值应该是 position             |
| 28   | -                         | -                                  | 单一解加入解集无条件                  |
| 28   | -                         | -                                  | 单一解先加入解集，后退出循环              |

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 思路：回溯 + 组合问题 
        // 1. 是否需要排序 => 不需要 
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => void helper(List<List<Integer>> result, List<Integer> list, int nums, int position);
        // 4. 递归何时退出 => position >= nums.length
        // 5. 单一解何时加入解集 => 无限制
        // 6. 剪枝
        // 7. 如何遍历子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<Integer> list = new ArrayList<>();
        helper(result, list, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        // 单一解何时加入解集 => deep copy
        result.add(new ArrayList<>(list));

        // 递归何时退出
        if (position >= nums.length) {
            return;
        }

        // 递归遍历子问题到下一层 + 剪枝
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);

            // 如何回溯
            list.remove(list.size() - 1);
        }
    }
}
```
