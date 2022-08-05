## 总结

https://leetcode.cn/problems/sort-array-by-parity/

```java
class Solution {
    // 问题1：什么类型数组 => 整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否有序 => 无序
    // 问题4：返回结果 => 返回任一数组作为答案
    // 问题5：函数定义
    // 问题6：检查输入参数
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 思路：原地交换 => 双指针，leftPoint 找到第一个奇数，rightPoint 找到第一个偶数，交换，重复
        // 新设数组 => [偶数, 奇数] => 遍历，偶数放前面，奇数放后面
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int[] result = new int[nums.length];
        int leftPoint = 0;
        int rightPoint = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[leftPoint++] = nums[i];
            } else {
                result[rightPoint--] = nums[i];
            }
        }

        return result;
    }
}
```

| 问题行数    | 错误点          | 正确写法         | 错误原因      |
|---------|--------------|--------------|-----------|
| 9       | nums = null  | nums == null | 判断相等，不是赋值 |
| 24      | rightPoint++ | rightPoint-- | 大意        |

