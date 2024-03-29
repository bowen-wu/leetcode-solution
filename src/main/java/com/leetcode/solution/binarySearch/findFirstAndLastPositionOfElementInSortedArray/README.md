## 在排序数组中查找元素的第一个和最后一个位置

<https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/>

### 思路

1. case => [5, 7, 7, 8, 8, 8, 8, 10] => 8 => [3, 6]
2. 找第一个小的 => 7 => smallerIndex: 2
3. 找第一个大的 => 10 => greaterIndex: 7
4. result => [smallerIndex + 1, greaterIndex - 1]

#### 优化

模板可以找到最左侧的target，此时相等移动的是 end 指针。如果要找最右侧的 target，那么相等时移动 start 即可

### 总结

| 问题行数 | 错误点                    | 正确写法                     | 错误原因                  |
|------|------------------------|--------------------------|-----------------------|
| 7    | Array.fill(result, -1) | Arrays.fill(result, -1); | 大意                    |
| 34   | target >= num[mid]     | target >= nums[mid]      | 大意                    |
| -    | -                      | -                        | 如果数组不满足条件则返回 [-1, -1] |

```java
class Solution {
    // 思路：两次二分查找，第一次二分查找确定 result[0]，第二次二分查找确定 result[1] O(logn)
    // 第一次二分查找相等时，end = mid
    // 第二次二分查找相等时，start = mid
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target == nums[start]) {
            result[0] = start;
        } else if (target == nums[end]) {
            result[0] = end;
        } else {
            return result;
        }

        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target == nums[start]) {
            result[1] = start;
        }

        if (target == nums[end]) {
            result[1] = end;
        }

        return result;
    }
}
```
