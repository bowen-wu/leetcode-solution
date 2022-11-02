## 小于 K 的两数之和

<https://leetcode.cn/problems/two-sum-less-than-k/>

### 思路

1. 排序后第一个值都大于 k，直接返回 -1
2. 如果最后 result 没有更新，那么返回 -1

### 总结

| 问题行数 | 错误点                                   | 正确写法                                              | 错误原因                  |
|------|---------------------------------------|---------------------------------------------------|-----------------------|
| 11   | int result = nums[start] + nums[end]; | int result = Integer.MIN_VALUE                    | 初始值错误。边界问题            |
| 30   | return result;                        | return result == Integer.MIN_VALUE ? -1 : result; | result 没有更新返回 -1。边界问题 |
| 14   | if (sum <= k)                         | if (sum < k)                                      | 不需要等于。边界问题            |

```java
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        // check input
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int result = Integer.MIN_VALUE;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < k) {
                if (sum > result) {
                    // update
                    result = sum;
                }
                start++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            } else {
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
```
