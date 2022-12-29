## 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面

<https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/>

### 思路

### 总结

| 问题行数 | 错误点         | 正确写法      | 错误原因     |
|------|-------------|-----------|----------|
| 5    | return null | return [] | [] -> [] |

```java
class Solution {
    public int[] exchange(int[] nums) {
        // Ideas: three pointer
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                result[end--] = nums[i];
            } else {
                result[start++] = nums[i];
            }
        }
        return result;
    }
}
```

test
