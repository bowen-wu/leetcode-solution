## 总结

https://leetcode.cn/problems/two-sum/

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 问题1：什么类型的数组 => 整数数组 => 包含正数负数
        // 问题2：是否有重复元素 => 无重复元素
        // 问题3：是否有序 => 无序
        // 问题4：怎么输出？=> 从小到大顺序数组输出，只需要一种答案
        // 问题5：函数定义
        // 问题6：检查输入参数
        // 思路1 => 暴力解法 => 两层for循环，时间复杂度 O(n^2)
        // 思路2 => 双指针 => 先排序之后使用双指针，时间复杂度 O(nlogn)
        // 数组考虑出界
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
```

1. 笔误 => leftPoint++ 应该是 leftPoint--
2. j = i 应该为 j = i + 1
