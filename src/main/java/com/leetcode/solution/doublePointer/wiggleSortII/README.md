## 摆动排序 II

<https://leetcode.cn/problems/wiggle-sort-ii/>

### 思路

1. 排序
2. 分成左右两个部分
3. 两个指针从后向前遍历
4. 第一部分从 middle 处遍历，使得如果是奇数，则剩余最小元素

### 总结

1. 思路 => 两个指针从后向前遍历即可

```java
class Solution {
    public void wiggleSort(int[] nums) {
        // 时间复杂度: O(nlogn)
        // 空间复杂度: O(n)
        // Ideas: 排序分成两部分，从后往前遍历，第一部分从 middle 开始
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[i] = nums[i];
        }

        int middle = len / 2;
        int first = len % 2 != 0 ? middle : middle - 1;
        int limit = first;
        int second = len - 1;
        int index = 0;
        while (second > limit) {
            nums[index++] = temp[first--];
            nums[index++] = temp[second--];
        }

        if (index < len) {
            nums[index] = temp[0];
        }
    }
}
```
