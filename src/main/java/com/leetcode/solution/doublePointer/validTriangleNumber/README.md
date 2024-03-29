## 有效三角形的个数

<https://leetcode.cn/problems/valid-triangle-number/>

### 思路

1. a + b > c => a + b == 两数之和
2. target 相当于第三边 => Two-Sum 大于 target 的个数 => target 从后往前取

### 总结

| 问题行数 | 错误点                                | 正确写法                               | 错误原因 |
|------|------------------------------------|------------------------------------|------|
| 11   | for (int i = len - 1; i >= 2; i++) | for (int i = len - 1; i >= 2; i--) | 大意   |

```java
class Solution {
    public int triangleNumber(int[] nums) {
        // a + b > c
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int result = 0;
        for (int i = len - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    result += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
```
