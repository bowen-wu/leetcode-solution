## 第一个错误的版本

<https://leetcode.cn/problems/first-bad-version/>

### 思路

1. 二分查找
2. 找到第一个 isBadVersion == true
3. 数组形式 => [GGGGGBBBBBBB]
4. start 是 Good, end 是 Bad
5. mid
    1. is Bad => end = mid
    2. is Good => start = mid

### 总结

1. 最后不能直接返回 end => 有可能一次都没有进入 while 循环 => case: [G, B]

```java
public class Solution extends VersionControl {
    // 思路：[GGGGGBBBBB]，找到第一个 Bad，二分查找 O(logn)
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }

        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                // Bad
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        }

        if (isBadVersion(end)) {
            return end;
        }

        return -1;
    }
}
```
