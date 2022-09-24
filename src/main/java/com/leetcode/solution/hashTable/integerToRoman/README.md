## 整数转罗马数字

<https://leetcode.cn/problems/integer-to-roman/>

### 思路

#### 优化

1. 数组代替 map
2. 使用 while + 减法

### 总结

| 问题行数 | 错误点                                                                                            | 正确写法                                                                                                 | 错误原因 |
|------|------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|------|
| 9    | int[] strs = new int[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; | String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; | 大意   |

```java
class Solution {
    public String intToRoman(int num) {
        // check input
        if (num <= 0) {
            return "";
        }

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ) {
            if (num >= nums[i]) {
                sb.append(strs[i]);
                num -= nums[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
```
