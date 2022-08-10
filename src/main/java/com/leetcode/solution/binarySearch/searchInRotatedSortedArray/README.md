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
