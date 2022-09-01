## 分割回文串 II

<https://leetcode.cn/problems/palindrome-partitioning-ii/>

### 思路

1. 找到所有的分割，list.size() - 1 最小的返回
2. 设置一个全局变量，如果当前分割比全局变量小则更新全局变量，如果当前分割比全局变量大，则放弃

#### 优化点

1. 如果当前的切割次数已经大于了 minCutNum，则放弃 => 当前切个次数使用**记忆化搜索**优化，获取值是 O(1) 的
