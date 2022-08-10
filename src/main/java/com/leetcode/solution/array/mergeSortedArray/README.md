## 总结

https://leetcode.cn/problems/merge-sorted-array/

```java
class Solution {
    // 问题1：什么类型数组 => 整数数组
    // 问题2：是否有重复元素 => 有
    // 问题3：是否有序 => 有
    // 问题4：如何输出结果 => 输出一个有序数组
    // 问题5：函数定义
    // 问题6：检查输入参数
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ((nums1 == null || nums1.length == 0) && nums2 != null) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int[] result = new int[m + n];
        int firstPoint = 0;
        int secondPoint = 0;
        int resultIndex = 0;

        while (firstPoint < m && secondPoint < n) {
            if (nums1[firstPoint] >= nums2[secondPoint]) {
                result[resultIndex++] = nums2[secondPoint++];
            } else {
                result[resultIndex++] = nums1[firstPoint++];
            }
        }

        // 查看剩余元素
        while (firstPoint < m) {
            result[resultIndex++] = nums1[firstPoint++];
        }

        while (secondPoint < n) {
            result[resultIndex++] = nums2[secondPoint++];
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    public int[] merge(int[] nums1, int[] nums2) {
        // 思路：双指针。比较两个指针所在位置的大小，小的放进去，之后移动指针，再次比较
        // 两个数组是否有剩余 =>
        // 时间复杂度：O(m + n)
        // 空间复杂度：O(m + n)
        int[] result = new int[nums1.length + nums2.length];
        int firstPoint = 0;
        int secondPoint = 0;
        int resultIndex = 0;

        while (firstPoint < nums1.length && secondPoint < nums2.length) {
            if (nums1[firstPoint] >= nums2[secondPoint]) {
                result[resultIndex++] = nums2[secondPoint++];
            } else {
                result[resultIndex++] = nums1[firstPoint++];
            }
        }

        // 查看剩余元素
        while (firstPoint < nums1.length) {
            result[resultIndex++] = nums1[firstPoint++];
        }

        while (secondPoint < nums2.length) {
            result[resultIndex++] = nums2[secondPoint++];
        }

        return result;
    }
}
```

| 问题行数 | 错误点                          | 正确写法                              | 错误原因                    |
|------|------------------------------|-----------------------------------|-------------------------|
| 24   | resultIndex < Math.min(m, n) | firstPoint < m && secondPoint < n | 边界条件判断错误，边界条件要举例，从特殊到一般 |

## 第三遍总结

```java
public class Third {
    public int[] merge(int[] nums1, int[] nums2) {
        // 思路
        // 双指针 => firstPointer + secondPointer，初始值为0，比较两者，较小的放入 result 中，之后移动较小的指针，继续比较。O(m + n)
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }

        int[] result = new int[nums1.length + nums2.length];
        int first = 0;
        int second = 0;
        for (int i = 0; i < result.length; i++) {
            if (nums1[first] > nums2[second]) {
                result[i] = nums2[second];
                second++;
            } else {
                result[i] = nums1[first];
                first++;
            }
        }

        return result;
    }
}
```

上述方案会出界。case：[1, 3], [2, 4, 5, 6] => first = 2，nums1[first] => ArrayIndexOutOfBoundsException

1. 使用 while 循环，判断条件为 first < nums1.length && second < nums2.length
2. 将剩余部分放入 result 中 

