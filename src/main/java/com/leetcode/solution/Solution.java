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
        System.out.println(solution.pick(3));
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    private final Map<Integer, List<Integer>> indexValueMap = new HashMap<>();

    public Solution(int[] nums) {
        // 时间复杂度：O(n)
        for (int i = 0; i < nums.length; i++) {
            if (indexValueMap.get(nums[i]) == null) {
                // 没有
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexValueMap.put(nums[i], list);
            } else {
                indexValueMap.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        // 时间复杂度：O(1)
        List<Integer> targetList = indexValueMap.get(target);
        int randomIndex = (int) (Math.random() * targetList.size());
        return targetList.get(randomIndex);
    }
}
