package com.leetcode.solution;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 35. 搜索插入位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1, 3}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        if (left == right) {
            return target <= nums[left] ? left : left + 1;
        }
        if (right < 0) {
            return 0;
        }
        if (target <= nums[right]) {
            return right;
        } else if (target <= nums[left]) {
            return left;
        } else {
            return left + 1;
        }
    }

    public int searchInsertForRecursion(int[] nums, int target) {
        return searchInsertForRecursion(0, nums.length - 1, nums, target);
    }

    public int searchInsertForRecursion(int left, int right, int[] nums, int target) {
        if (left == right) {
            int value = nums[left];
            if (target == value) {
                return left;
            } else if (value < target) {
                return left + 1;
            } else {
                return Math.max(left - 1, 0);
            }
        }
        if (left + 1 == right) {
            int leftValue = nums[left];
            int rightValue = nums[right];
            if (target < leftValue) {
                return Math.max(left - 1, 0);
            } else if (target == leftValue) {
                return left;
            } else if (target < rightValue) {
                return left + 1;
            } else if (target == rightValue) {
                return right;
            } else {
                return right + 1;
            }
        }

        int mid = (left + right) / 2;
        int midValue = nums[mid];
        if (target < midValue) {
            return searchInsertForRecursion(left, mid, nums, target);
        } else if (target == midValue) {
            return mid;
        } else {
            return searchInsertForRecursion(mid, right, nums, target);
        }
    }
}
