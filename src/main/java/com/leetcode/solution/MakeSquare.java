package com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/matchsticks-to-square/
 * 473. 火柴拼正方形
 * 动态规划
 */
public class MakeSquare {
    public static void main(String[] args) {
//        System.out.println(new MakeSquare().makesquare(new int[]{1, 1, 2, 2, 2})); // true
//        System.out.println(new MakeSquare().makesquare(new int[]{3, 3, 3, 3, 4})); // false
//        System.out.println(new MakeSquare().makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3})); // true
//        System.out.println(new MakeSquare().makesquare(new int[]{12, 13, 1, 15, 11, 17, 16, 3, 15, 11, 13, 4, 2, 16, 15})); // true
//        System.out.println(new MakeSquare().makesquare(new int[]{1, 1, 1, 1})); // true
        System.out.println(new MakeSquare().makesquare(new int[]{3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2})); // true
    }

    public boolean makesquare(int[] matchsticks) {
        int length = matchsticks.length;
        if (length < 4) {
            return false;
        }

        int sum = 0;
        int min = matchsticks[0];
        int max = matchsticks[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int currentValue : matchsticks) {
            sum += currentValue;
            if (min > currentValue) {
                min = currentValue;
            }
            if (max < currentValue) {
                max = currentValue;
            }
            map.merge(currentValue, 1, Integer::sum);
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        int side = sum / 4;
        int rightSide = matchsticks[length - 2];
        int bottomSide = matchsticks[length - 3];
        int leftSide = matchsticks[length - 4];
        for (int i = matchsticks.length - 5; i >= 0; i--) {
            int currentValue = matchsticks[i];
            if (currentValue > side) {
                return false;
            }
            if ((leftSide + currentValue == side) || (side - leftSide - currentValue >= min)) {
                leftSide += currentValue;
            } else if (bottomSide + currentValue == side || (side - bottomSide - currentValue >= min)) {
                bottomSide += currentValue;
            } else if (rightSide + currentValue == side || (side - rightSide - currentValue >= min)) {
                rightSide += currentValue;
            }
            if (leftSide == side && bottomSide == side && rightSide == side) {
                return true;
            }
        }
        return leftSide == side && bottomSide == side && rightSide == side;
    }
}
