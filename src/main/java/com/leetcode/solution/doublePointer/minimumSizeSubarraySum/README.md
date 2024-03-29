## 长度最小的子数组

<https://leetcode.cn/problems/minimum-size-subarray-sum/>

### 思路

1. sidling window
2. 如何扩展 => 和小于 target
3. 如何收窄 => 移除当前值

### 总结

| 问题行数 | 错误点             | 正确写法                            | 错误原因              |
|------|-----------------|---------------------------------|-------------------|
| 7    | int result = 0; | int result = Integer.MAX_VALUE; | result 初始值问题。边界问题 |

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }

            if (sum >= target) {
                result = Math.min(result, j - i);
            }
            sum -= nums[i];
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
```
