## 数组中的第K个最大元素

<https://leetcode.cn/problems/kth-largest-element-in-an-array/>

### 思路

### 总结

| 问题行数 | 错误点                                | 正确写法                              | 错误原因       |
|------|------------------------------------|-----------------------------------|------------|
| 34   | for (int i = start; i <= end; i++) | for (int i = start; i < end; i++) | i 不需要到 end |

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // check input
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }

        return quickSort(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int pivot = partition(nums, start, end);
        if (pivot == k - 1) {
            return nums[pivot];
        }

        if (pivot < k - 1) {
            // 高区
            return quickSort(nums, pivot + 1, end, k);
        }
        return quickSort(nums, start, pivot - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // j 是第一个小于 pivotValue 的位置
        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;

                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }

        swap(nums, j + 1, end);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
