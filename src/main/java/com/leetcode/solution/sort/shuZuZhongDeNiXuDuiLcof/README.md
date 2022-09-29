## 数组中的逆序对

<https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/>

### 思路

1. 归并排序中 nums[left] > nums[right] 时 leftLength - left 的个数就是当前 left 位置的逆序对总数
2. 注意：如果使用 temp => 个数就是下标做减法，就没有 length 了 => ` result += mid + 1 - left `

### 总结

| 问题行数    | 错误点                                                     | 正确写法                                                                    | 错误原因                             |
|---------|---------------------------------------------------------|-------------------------------------------------------------------------|----------------------------------|
| 22      | return mergeTwoSortedArray(nums, start, end, mid, temp) | return mergeTwoSortedArray(nums, start, end, mid, temp) + left + right; | combine 错误。思路问题                  |
| 48 - 50 | -                                                       | -                                                                       | 没有将 temp copy 到 nums。归并排序模板默写不熟练 |
| 33 - 36 | if (nums[first] < nums[second])                         | if (nums[first] > nums[second])                                         | 取错逆序对位置。细节问题                     |

```java
class Solution {
    public int reversePairs(int[] nums) {
        // Ideas: MergeSort => 合并的时候前一个值大于后一个值，那么该值后面的都大于
        // O(n * logn) + O(n)
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
        return mergeTwoSortedArray(nums, start, end, mid, temp) + left + right;
    }

    private int mergeTwoSortedArray(int[] nums, int start, int end, int mid, int[] temp) {
        int index = start;
        int first = start;
        int second = mid + 1;
        int result = 0;
        while (first <= mid && second <= end) {
            if (nums[first] > nums[second]) {
                // first < second && nums[first] > nums[second]
                result += mid - first + 1;
                temp[index++] = nums[second++];
            } else {
                temp[index++] = nums[first++];
            }
        }

        // remaining
        while (first <= mid) {
            temp[index++] = nums[first++];
        }
        while (second <= end) {
            temp[index++] = nums[second++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }

        return result;
    }
}
```
