package com.leetcode.solution.binarySearch.firstBadVersion.second;

import com.leetcode.solution.binarySearch.firstBadVersion.FirstBadVersionTemplate;

public class FirstBadVersion extends FirstBadVersionTemplate {
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
