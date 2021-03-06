package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * 398. 随机数索引
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick1(3));
    }

    private final int[] nums;
    private final Map<Integer, List<Integer>> valueIndexCache;

    public Solution(int[] nums) {
        this.nums = nums;
        this.valueIndexCache = new HashMap<>();
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int pick(int target) {
        List<Integer> targetIndexList = new ArrayList<>();
        if (valueIndexCache.get(target) != null) {
            targetIndexList = valueIndexCache.get(target);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    targetIndexList.add(i);
                }
            }
            valueIndexCache.put(target, targetIndexList);
        }

        int randomIndex = (int) (Math.random() * targetIndexList.size());
        return targetIndexList.get(randomIndex);
    }

    // 蓄水池抽样
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int pick1(int target) {
        int targetNumber = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetNumber++;
                if (Math.floor(Math.random() * targetNumber) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
