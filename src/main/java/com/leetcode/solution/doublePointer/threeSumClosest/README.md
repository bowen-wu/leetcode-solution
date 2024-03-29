## 最接近的三数之和

<https://leetcode.cn/problems/3sum-closest/>

### 思路

#### 优化

1. sum == target => return target

### 总结

| 问题行数 | 错误点 | 正确写法               | 错误原因 |
|------|-----|--------------------|------|
| 8    | -   | Arrays.sort(nums); | 没有排序 |

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // check input
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    // update
                    result = sum;
                }
                if (sum < target) {
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
        }

        return result;
    }
}
```
