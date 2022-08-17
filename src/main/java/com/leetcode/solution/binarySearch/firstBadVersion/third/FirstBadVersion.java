package com.leetcode.solution.binarySearch.firstBadVersion.third;

import com.leetcode.solution.binarySearch.firstBadVersion.FirstBadVersionTemplate;

public class FirstBadVersion extends FirstBadVersionTemplate {
    @Override
    public int firstBadVersion(int n) {
        // 思路：[GGGBBBBB]
        if (n <= 0) {
            return -1;
        }

        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                // case: GBB GGB
                start = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        }

        return end;
    }
}
