package com.leetcode.solution.array.twoSum.second;

import com.leetcode.solution.array.twoSum.TwoSumTemplate;

import java.util.Arrays;

public class TwoSum extends TwoSumTemplate {
    @Override
    public int[] twoSum(int[] nums, int target) {
        // 问题1：什么类型的数组 => 整数数组 => 包含正数负数
        // 问题2：是否有重复元素 => 无重复元素
        // 问题3：是否有序 => 无序
        // 问题4：怎么输出？=> 从小到大顺序数组输出，只需要一种答案
        // 问题5：函数定义
        // 问题6：检查输入参数
        // 思路1 => 暴力解法 => 两层for循环，时间复杂度 O(o^2)
        // 思路2 => 双指针 => 先排序之后使用双指针，时间复杂度 O(nlogn)

        Arrays.sort(nums);
        int leftPoint = 0;

        // 数组考虑出界
        int rightPoint = nums.length - 1;
        while(leftPoint < rightPoint) {
            if(nums[leftPoint] + nums[rightPoint] == target) {
                return new int[]{nums[leftPoint], nums[rightPoint]};
            }
            if(nums[leftPoint] + nums[rightPoint] > target) {
                rightPoint--;
            }
            if(nums[leftPoint] + nums[rightPoint] < target) {
                leftPoint++;
            }
        }

        return null;
    }
}
