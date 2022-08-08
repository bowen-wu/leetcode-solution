## 下一个更大元素 I

<https://leetcode.cn/problems/next-greater-element-i/>

### 思路

单调栈

- **右侧** => 从左向右
- **Greater** => 栈底到栈顶单调递减

nums2 => [1, 3, 4, 2]
nums2Greater => [3, 4, -1, -1]
nums1 => [4, 1, 2] => [2, 0, 3] => 到num2Greater => [-1, 3, -1]

#### 优化

1. 使用 map 存储 nums2Greater => (nums2[i] -> greater)

### 总结

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        // key: 元素本身 value：右侧比它大的第一个元素
        Map<Integer, Integer> nums2GreaterMap = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        // 右侧 => 从左向右
        for (int i = 0; i < nums2.length; i++) {
            // Greater => 栈底到栈顶单调递减
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nums2GreaterMap.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            if (nums2GreaterMap.containsKey(nums1[i])) {
                result[i] = nums2GreaterMap.get(nums1[i]);
            }
        }

        return result;
    }
}
```

| 问题行数 | 错误点            | 正确写法 | 错误原因                                                                                   |
|------|----------------|------|----------------------------------------------------------------------------------------|
| 19   | -              | -    | 未初始化 result -1                                                                         |
| 21   | 未进行判断 contains | -    | 有可能没有比它大的，那么在 map 中将没有该值, case: 412, 1342 -> map {1:3, 3:4}，此时取4将 NullPointerException |


