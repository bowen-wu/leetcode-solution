## 子集

<https://leetcode.cn/problems/subsets/>

### 思路

1. backtracking 模板
2. 递归何时退出 => 开始的位置大于 nums.length
3. 单一解何时加入到解集中 => 新增数据后
4. 递归分解子问题 => for loop => 初始值是开始的位置
5. 何时回溯 + 怎么回溯 => 遍历完以当前节点为开头的所有数组 + 移除最后一个元素
