package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 442. 数组中重复的数据
 */
public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println(new FindDuplicates().findDuplicates(new int[]{1, 1, 2}));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int current : nums) {
            if (map.get(current) == null) {
                map.put(current, 1);
            } else {
                result.add(current);
            }
        }
        return result;
    }
}
