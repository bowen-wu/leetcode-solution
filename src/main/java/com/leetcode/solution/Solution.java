package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * 398. 随机数索引
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution.pick(3));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> targetIndexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetIndexList.add(i);
            }
        }

        int randomIndex = (int) (Math.random() * targetIndexList.size());
        return targetIndexList.get(randomIndex);
    }
}
