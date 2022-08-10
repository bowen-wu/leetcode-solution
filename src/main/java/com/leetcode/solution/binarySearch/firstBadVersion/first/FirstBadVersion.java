package com.leetcode.solution.binarySearch.firstBadVersion.first;

import com.leetcode.solution.binarySearch.firstBadVersion.FirstBadVersionTemplate;

public class FirstBadVersion extends FirstBadVersionTemplate {
    @Override
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }

        int start = 1;
        int end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid)) {
                start = mid;
            } else {
                end = mid;
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

    private boolean isBadVersion(int num) {
        return false;
    }

}
