## 对称二叉树

<https://leetcode.cn/problems/symmetric-tree/>

### 思路

1. 分治法 => 左右两颗子树对称不能推出树对称，所以不能使用分治法
2. 遍历法 => 何时更新全局变量 => 不对称的时候

#### 优化

1. 可以不使用全局变量，helper 函数带有返回值 boolean
