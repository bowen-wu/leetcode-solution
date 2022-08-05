package com.leetcode.solution.array.threeSum.second;

import com.leetcode.solution.array.threeSum.ThreeSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum extends ThreeSumTemplate {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    @Override
    public int[] threeSum(int[] nums, int target) {
        // 问题1：什么类型的数组 => n个整数数组
        // 问题2：是否有重复元素 => 无重复元素
        // 问题3：是否有序 => 无序
        // 问题4：怎么输出 => 输出任意一个答案数组
        // 问题5：函数定义
        // 问题6：检查输入参数
        // 思路1 => 暴力解法 => 三层for循环，时间复杂度O(n^3)
        // 思路2 => 排序+双指针 => 排序后确定第一个数，之后使用双指针，时间复杂度O(n^2)

        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int leftPoint = i + 1;
            int rightPoint = nums.length - 1;
            while (leftPoint < rightPoint) {
                if (first + nums[leftPoint] + nums[rightPoint] == target) {
                    return new int[]{first, nums[leftPoint], nums[rightPoint]};
                }
                if (first + nums[leftPoint] + nums[rightPoint] > target) {
                    rightPoint--;
                }
                if (first + nums[leftPoint] + nums[rightPoint] < target) {
                    leftPoint++;
                }
            }
        }

        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 问题1：什么类型的数组 => n个整数数组
        // 问题2：是否有重复元素 => 无重复元素
        // 问题3：是否有序 => 无序
        // 问题4：怎么输出 => 输出所有答案数组
        // 问题5：函数定义
        // 问题6：检查输入参数
        // 思路1 => 暴力解法 => 三层for循环，时间复杂度O(n^3)
        // 思路2 => 排序+双指针 => 排序后确定第一个数，之后使用双指针，时间复杂度O(n^2)

        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<String, Integer> cache = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // -4 -1 -1 0 1 2
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int leftPoint = i + 1;
            int rightPoint = nums.length - 1;
            while (leftPoint < rightPoint) {
                if (first + nums[leftPoint] + nums[rightPoint] == 0 && cache.get("" + first + nums[leftPoint] + nums[rightPoint]) == null) {
                    result.add(Arrays.asList(first, nums[leftPoint], nums[rightPoint]));
                    cache.put("" + first + nums[leftPoint] + nums[rightPoint], 1);
                    leftPoint++;
                }
                if (first + nums[leftPoint] + nums[rightPoint] > 0) {
                    rightPoint--;
                }
                if (first + nums[leftPoint] + nums[rightPoint] < 0) {
                    leftPoint++;
                }
            }
        }

        return result;
    }
}
