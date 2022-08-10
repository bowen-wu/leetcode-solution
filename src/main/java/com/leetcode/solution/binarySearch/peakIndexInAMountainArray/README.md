## 山脉数组的峰顶索引

<https://leetcode.cn/problems/peak-index-in-a-mountain-array/>

### 思路

1. 暴力查找最大元素 => O(n)
2. 二分查找 => start, end, mid => mid 和 mid + 1 比较
    - nums[mid] < nums[mid + 1] => 落在了**单调递增**上 => start = mid
    - nums[mid] > nums[mid + 1] => 落在了**单调递减**上 => end = mid

#### 优化

1. 二分查找后得到了 start 和 end，返回最大值的 index。左右两侧爬升，都差一个就到达了顶点，即最大值。此时 mid 为最大值
    - 若使用 nums[mid] > nums[mid + 1] => 单调递减 => end = mid => 直接返回 end
    - 若使用 nums[mid] > nums[mid - 1] => 单调递增 => start = mid => 直接返回 start
