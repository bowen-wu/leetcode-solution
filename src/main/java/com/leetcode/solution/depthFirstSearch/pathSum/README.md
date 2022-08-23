## 路径总和

<https://leetcode.cn/problems/path-sum/>

### 思路

1. 分治法 => 左右子树分别找 target - currentValue，如果是叶子节点，直接比较即可
2. 遍历法 => 如果是叶子节点，直接返回叶子节点的值
