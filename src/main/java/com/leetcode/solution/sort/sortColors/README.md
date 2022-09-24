## 颜色分类

<https://leetcode.cn/problems/sort-colors/>

### 思路

1. 快排 => [0, 1] + [2]
2. 三指针 => start + end + i
    1. i = start
    2. nums[i] == 0 => swap(i, start) => start++ => i++
    3. nums[i] == 2 => swap(i, end) => end-- => **此时不能 i++，需要判断之前 end 位置的地方是否是 0**
    4. nums[i] == 1 => i++

### 总结

| 问题行数 | 错误点        | 正确写法     | 错误原因                       |
|------|------------|----------|----------------------------|
| 18   | -          | end--    | 需要移动 end 指针。思路问题           |
| 11   | i < end    | i <= end | i 需要移动到 end。边界问题           |
| 18   | end--; i++ | end--    | 和 end swap 的时候指针不能移动。思路问题  |
| 21   | -          | i++      | 当 nums[i] == 1 时，移动指针。思路问题 |

```java
class Solution {
    public void sortColors(int[] nums) {
        // Ideas: 三指针 => 第一根指0，第二根指2，第三根移动
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0;
        int end = nums.length - 1;
        for (int i = start; i <= end; ) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else {
                // nums[i] == 1
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
