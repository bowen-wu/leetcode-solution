## 总结

https://leetcode.cn/problems/3sum/

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 问题1：什么类型的数组 => n个整数数组
        // 问题2：是否有重复元素 => 无重复元素
        // 问题3：是否有序 => 无序
        // 问题4：怎么输出 => 输出所有答案数组
        // 问题5：函数定义
        // 问题6：检查输入参数
        // 思路1 => 暴力解法 => 三层for循环，时间复杂度O(n^3)
        // 思路2 => 排序+双指针 => 排序后确定第一个数，之后使用双指针，时间复杂度O(n^2)
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<String, Integer> cache = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int leftPoint = i + 1;
            int rightPoint = nums.length - 1;
            while (leftPoint < rightPoint) {
                if (first + nums[leftPoint] + nums[rightPoint] == 0) {
                    if (cache.get("" + first + nums[leftPoint] + nums[rightPoint]) == null) {
                        result.add(Arrays.asList(first, nums[leftPoint], nums[rightPoint]));
                        cache.put("" + first + nums[leftPoint] + nums[rightPoint], 1);
                    }
                    leftPoint++;
                }
                if (first + nums[leftPoint] + nums[rightPoint] > 0) {
                    rightPoint--;
                }
                if (first + nums[leftPoint] + nums[rightPoint] < 0) {
                    leftPoint++;
                }
            }
        }

        return result;
    }
}
```

| 问题行数    | 错误点                  | 正确写法              | 错误原因                                 |
|---------|----------------------|-------------------|--------------------------------------|
| 26      | -                    | cache.put()       | cache没有时应该 put                       |
| 16      | new List<>()         | new ArrayList<>() | API 问题                               |
| 23      | == target            | == 0              | 当前 target 为 0                        |
| 25      | Collections.asList() | Arrays.asList()   | API 问题                               |
| 23 - 24 | -                    | -                 | 死循环了，在 == 0 && 不 add 时也要 leftPoint++ |

