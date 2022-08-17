package com.leetcode.solution.binarySearch.sqrtx.third;

import com.leetcode.solution.binarySearch.sqrtx.MySqrtTemplate;

public class MySqrt extends MySqrtTemplate {
    public int mySqrt(int x) {
        // 思路：二分查找逼近
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }

        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end <= x / end) {
            return end;
        }
        if (start <= x / start) {
            return start;
        }

        return -1;
    }
}
