## 颜色分类

<https://leetcode.cn/problems/sort-colors/>

### 思路

1. 快排 => [0, 1] + [2]
2. 三指针 => start + end + i
    1. i = start
    2. nums[i] == 0 => swap(i, start) => start++ => i++
    3. nums[i] == 2 => swap(i, end) => end-- => **此时不能 i++，需要判断之前 end 位置的地方是否是 0**
    4. nums[i] == 1 => i++
