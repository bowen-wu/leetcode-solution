## 翻转对

<https://leetcode.cn/problems/reverse-pairs/>

### 思路

1. 归并排序 => 合并两个有序数组 => [start, mid] 和 [mid + 1, end] 是有序的
2. 在 [start, end] 找重要翻转对
3. 不能使用除法，Java 中除法是地板除

### 总结

1. 合并两个有序数组，剩余部分使用 while 循环，而不是 if
2. 合并两个有序数组，剩余部分使用 while 循环，而不是 if
3. 合并两个有序数组，剩余部分使用 while 循环，而不是 if
4. 合并两个有序数组，剩余部分使用 while 循环，而不是 if
5. 合并两个有序数组，剩余部分使用 while 循环，而不是 if

| 问题行数 | 错误点                      | 正确写法                  | 错误原因       |
|------|--------------------------|-----------------------|------------|
| 25   | int index = 0;           | int index = start;    | 细节问题       |
| 52   | while (second <= middle) | while (second <= end) | 细节问题       |
| 31   | -                        | 2.0 *                 | integer 越界 |

```java
class Solution {
    public int reversePairs(int[] nums) {
        // Ideas: Merge Sort
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int left = mergeSort(nums, start, mid, temp);
        int right = mergeSort(nums, mid + 1, end, temp);
        return mergeTwoSortedArray(nums, start, mid, end, temp) + left + right;
    }

    private int mergeTwoSortedArray(int[] nums, int start, int mid, int end, int[] temp) {
        int index = start;
        int first = start;
        int second = mid + 1;
        int result = 0;
        while (first <= mid && second <= end) {
            // first < second && nums[first] > 2 * nums[second] 
            if (nums[first] > 2.0 * nums[second]) {
                result += mid - first + 1;
                second++;
            } else {
                first++;
            }
        }

        first = start;
        second = mid + 1;
        while (first <= mid && second <= end) {
            if (nums[first] < nums[second]) {
                temp[index++] = nums[first++];
            } else {
                temp[index++] = nums[second++];
            }
        }

        // remaining
        while (first <= mid) {
            temp[index++] = nums[first++];
        }
        while (second <= end) {
            temp[index++] = nums[second++];
        }

        // copy
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }

        return result;
    }
}
```
