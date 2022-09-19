## 数组中的逆序对

<https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/>

### 思路

1. 归并排序中 nums[left] > nums[right] 时 leftLength - left 的个数就是当前 left 位置的逆序对总数
2. 注意：如果使用 temp => 个数就是下标做减法，就没有 length 了 => ` result += mid + 1 - left `
