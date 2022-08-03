package com.leetcode.solution.array.fourSum.first;

import com.leetcode.solution.array.fourSum.FourSumTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class FourSum extends FourSumTemplate {
    public static void main(String[] args) {
//        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
//        System.out.println(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
//        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
//        System.out.println(fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序 => O(nlogn)
        // for loop + for loop + while => O(n^3)
        // 时间复杂度：O(n^3)
        // 空间复杂度：O(1)
        HashMap<String, Integer> cache = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] > 0 && target < 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int leftPoint = j + 1;
                int rightPoint = nums.length - 1;
                while (leftPoint < rightPoint) {
                    if (nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint] == target) {
                        if (cache.get("" + nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint]) == null) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[leftPoint], nums[rightPoint]));
                            cache.put("" + nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint], 1);
                        }
                        leftPoint++;
                    }
                    if (nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint] > target) {
                        rightPoint--;
                    }
                    if (nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint] < target) {
                        leftPoint++;
                    }
                }
            }
        }
        return result;
    }
}
