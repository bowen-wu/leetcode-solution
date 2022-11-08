## 乘积最大子数组

<https://leetcode.cn/problems/maximum-product-subarray/>

### 思路

1. State => dp[i] 代表以 nums[i] 结尾的子数组最大乘积
2. case：2, -2, 2, -2 => 最大值应该 16
3. State => 需要有两个 dp
    1. maxDp[i] 代表以 nums[i] 结尾的子数组最大乘积
    2. minDp[i] 代表以 nums[i] 结尾的子数组最小乘积 => 考虑**负负得正**
4. Function
    1. nums[i] > 0 =>
        1. maxDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] * nums[i] : nums[i]
        2. minDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] * nums[i] : nums[i]
    2. nums[i] < 0 =>
        1. maxDp[i] = minDp[i - 1] < 0 ? minDp[i - 1] * nums[i] : nums[i]
        2. minDp[i] = maxDp[i - 1] > 0 ? maxDp[i - 1] * nums[i] : nums[i]
5. Condition =>
    1. maxDp[0] = nums[0];
    2. minDp[0] = nums[0];

#### 优化

1. 滚动数组 => minState + maxState + max

### 总结

1. 思路问题
2. 当 nums[i] < 0 时需要把 maxValue 缓存起来

```java
class Solution {
    public int maxProduct(int[] nums) {
        // state => f(n) 表示以 nums[n] 结尾的最大子数组积
        //      有正负两个数组 => prevMaxValue + prevMinValue
        // status function => f(n) = 
        //                      nums[i] < 0 => nums[i] * 正数(负值) + nums[i] * 负数(正值) => 更新最大值和最小值
        //                      nums[i] > 0 => nums[i] * 正数(正值) + nums[i] * 负数(负值) => 更新最大值和最小值
        // case: 2, 3, -2,  2,  3,  -2, -100
        //       2  6   1   2   6  144  1200
        //             -12 -24 -72 -12
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevMaxValue = nums[0];
        int prevMinValue = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                prevMaxValue = prevMaxValue > 0 ? prevMaxValue * nums[i] : nums[i];
                prevMinValue = prevMinValue < 0 ? prevMinValue * nums[i] : nums[i];
            } else {
                // nums[i] <= 0
                int temp = prevMaxValue;
                prevMaxValue = prevMinValue < 0 ? prevMinValue * nums[i] : nums[i];
                prevMinValue = temp > 0 ? temp * nums[i] : nums[i];
            }
            max = Math.max(max, prevMaxValue);
        }

        return max;
    }
}
```
