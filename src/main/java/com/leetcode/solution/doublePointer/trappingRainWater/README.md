## 接雨水

<https://leetcode.cn/problems/trapping-rain-water/>

### 思路

1. 遍历 => 获取左右边界，之后计算储水量即可
2. 双指针 => 移动短板
    - height[start] < height[end] => start++
    - height[start] > height[end] => end--

#### 优化

1. 双指针比较 leftMax 和 rightMax

### 总结
