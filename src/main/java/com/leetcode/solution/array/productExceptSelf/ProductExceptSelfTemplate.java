package com.leetcode.solution.array.productExceptSelf;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/
 * 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * <p>
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
abstract public class ProductExceptSelfTemplate {
    abstract public int[] productExceptSelf(int[] nums);
}
