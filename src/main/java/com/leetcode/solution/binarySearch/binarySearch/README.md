## 二分查找

<https://leetcode.cn/problems/binary-search/>

### 思路

二分搜索

### 总结

| 问题行数 | 错误点     | 正确写法        | 错误原因  |
|------|---------|-------------|-------|
| 12   | start++ | start = mid | 还需要练习 |
| 14   | end++   | end = mid   | 还需要练习 |

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
```
