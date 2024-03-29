## 两数之和

<https://leetcode.cn/problems/two-sum/>

### 思路

1. 遍历数组 => map => value -> index

### 总结

| 问题行数 | 错误点                                    | 正确写法                                            | 错误原因 |
|------|----------------------------------------|-------------------------------------------------|------|
| 12   | return new int[]{map.get(nums[i]), i}; | return new int[]{map.get(target - nums[i]), i}; | 大意   |

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // check input
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // map => value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
```
