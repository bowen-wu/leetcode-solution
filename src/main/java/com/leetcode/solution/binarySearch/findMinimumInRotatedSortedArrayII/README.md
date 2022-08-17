## 寻找旋转排序数组中的最小值

<https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/>

### 思路

**有重复元素**，二分查找

1. nums[start] < nums[end] => 没有旋转过 => min = nums[start]
2. nums[start] >= nums[end] => 旋转过，记最大值的 index = maxIndex
    1. start < mid => mid 在 (start, maxIndex) => target == min => start = mid
    2. start > mid => start 是最小值，所以 mid 在 (maxIndex + 1, end) => end = mid
    3. start == mid => 不知道 mid 落在了哪个区域内 => start++ => 移动一位之后有可能进入右侧 =>
       此时 start 和 end 都在 (maxIndex + 1, end) 区域内，此时需要判断是否是单调递增。case：[10, 1, 10, 10, 10]
      ```
      // mid 落在右侧，end = mid
      s    |   m          e
      ---- |  -------------
           |--
   
      // mid 落在左侧，start = mid
      s       m     |    e
      ------------- |  ---
                    |--
      ```

**start++ 之后，有可能落入同一个单调递增区间内 => 要在 while 循环中判断是否无旋转**

### 总结

| 问题行数 | 错误点                    | 正确写法 | 错误原因                           |
|------|------------------------|------|--------------------------------|
| 21   | nums[mid] <= nums[end] | -    | 如果出现相等的情况，不能判断是移动 start 还是 end |

```java
class Solution {
    public int findMin(int[] nums) {
        // 思路：start < end => 未旋转
        // 		start > end => 旋转
        // 			start < mid => start = mid
        //			mid < end => end = mid
        //			相等的情况 => start++ => 需要查看 start 是否移到了下部
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            if (nums[start] < nums[mid]) {
                start = mid;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start++;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
```
