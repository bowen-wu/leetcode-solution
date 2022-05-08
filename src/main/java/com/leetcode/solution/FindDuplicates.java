package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 442. 数组中重复的数据
 */
public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println(new FindDuplicates().findDuplicates(new int[]{1, 1, 2}));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 原地哈希
    // 4,3,2,2,3,1  => ans []
    // 4,3,2,-2,3,1  => ans []
    // 4,3,-2,-2,3,1  => ans []
    // 4,-3,-2,-2,3,1  => ans []
    // 4,-3,-2,-2,3,1  => ans [2]
    // 4,-3,-2,-2,3,1  => ans [2, 3]
    // -4,-3,-2,-2,3,1  => ans [2, 3]
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int valueAbs = Math.abs(nums[i]);
            if (nums[valueAbs - 1] > 0) {
                nums[valueAbs - 1] = -nums[valueAbs - 1];
            } else {
                result.add(valueAbs);
            }
        }

        return result;
    }
}
