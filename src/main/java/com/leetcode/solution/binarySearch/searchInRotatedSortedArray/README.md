## 搜索旋转排序数组

<https://leetcode.cn/problems/search-in-rotated-sorted-array>

### 思路

1. 暴力 => O(n)
2. 二分查找。最大值的 index 为 maxIndex。
    1. nums[start] < nums[end] => 无旋转
    2. nums[start] > nums[end] => 有旋转
3. 二分，最大值的 index 为 maxIndex。target 和 start 比较
    1. target > start => target 落在了 (start, maxIndex)
        - mid < end => end = mid
        - mid > end
            - mid > target => end = mid
            - mid < target => start = mid
    2. target < start => target 落在了 (maxIndex + 1, end)
        - mid > end => start = mid
        - mid < end
            - mid < target => start = mid
            - mid > target => end = mid

#### 优化

1. mid 先和 end 做比较
    - mid > end
        - nums[start] <= target && target <= nums[mid] => end = mid
        - start = mid
    - mid < end
        - nums[mid] <= target && target <= nums[end] => start = mid
        - end = mid
2. mid 也可和 start 做比较

### 总结

| 问题行数 | 错误点                                  | 正确写法 | 错误原因                |
|------|--------------------------------------|------|---------------------|
| 17   | nums[mid] <= target && target <= end | -    | 应该和 nums[end] 比较。大意 |

```java
class Solution {
    public int search(int[] nums, int target) {
        // 思路：start < end => 未旋转 => 和旋转可以一样的逻辑
        // 		start > end => 旋转 => 比较 start mid end，看 target 在哪段，舍弃另一段
        //      			mid 在 下部 => mid <= target <= end : start = mid => else end = mid
        //  				mid 在 上部 => start <= target <= mid : end = mid => else start = mid	
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                // mid 在下部
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                // mid 在上部 或未旋转	
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (target == nums[start]) {
            return start;
        }

        if (target == nums[end]) {
            return end;
        }

        return -1;
    }
}
```
