package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/cut-off-trees-for-golf-event/
 * 675. 为高尔夫比赛砍树
 */
public class CutOffTree {
    public static void main(String[] args) {
//        System.out.println(new CutOffTree().cutOffTree(Arrays.asList(Arrays.asList(2, 3, 4), Arrays.asList(0, 0, 5), Arrays.asList(8, 7, 6)))); // 6
//        System.out.println(new CutOffTree().cutOffTree(Arrays.asList(Arrays.asList(2, 3, 4), Arrays.asList(0, 0, 0), Arrays.asList(8, 7, 6)))); // -1
//        System.out.println(new CutOffTree().cutOffTree(Arrays.asList(Arrays.asList(0, 0, 1)))); // -1

//        [54581641, 64080174, 24346381, 69107959]
//        [86374198, 61363882, 68783324, 79706116]
//        [668150, 92178815, 89819108, 94701471]
//        [83920491, 22724204, 46281641, 47531096]
//        [89078499, 18904913, 25462145, 60813308]
        System.out.println(new CutOffTree().cutOffTree(Arrays.asList(Arrays.asList(54581641, 64080174, 24346381, 69107959), Arrays.asList(86374198, 61363882, 68783324, 79706116), Arrays.asList(668150, 92178815, 89819108, 94701471), Arrays.asList(668150, 92178815, 89819108, 94701471), Arrays.asList(83920491, 22724204, 46281641, 47531096), Arrays.asList(89078499, 18904913, 25462145, 60813308)))); // 57
    }

    // 排序
    public int cutOffTree(List<List<Integer>> forest) {
        int[] currentPosition = new int[]{0, 0};
        List<int[]> path = new ArrayList<>();
        int[] nextPosition = currentPosition;
        int count = 0;
        for (List<Integer> integers : forest) {
            for (Integer integer : integers) {
                if (integer != 0) {
                    count++;
                }
            }
        }
        while ((nextPosition = getNextPosition(nextPosition, forest)) != null) {
            path.add(nextPosition);
        }

        if ((forest.get(0).get(0) == 0 && path.size() == count) || (forest.get(0).get(0) > 0 && path.size() + 1 == count)) {
            return path.size();
        }

        return -1;
    }

    private int[] getNextPosition(int[] currentPosition, List<List<Integer>> forest) {
        int currentValue = forest.get(currentPosition[1]).get(currentPosition[0]);
        int[] nextPosition = null;
        int minDistance = Integer.MAX_VALUE;
        if (currentPosition[0] - 1 >= 0) {
            int leftValue = forest.get(currentPosition[1]).get(currentPosition[0] - 1);
            if (leftValue - currentValue < minDistance && leftValue - currentValue > 0) {
                minDistance = leftValue - currentValue;
                nextPosition = new int[2];
                nextPosition[0] = currentPosition[0] - 1;
                nextPosition[1] = currentPosition[1];
            }
        }
        if (currentPosition[0] + 1 < forest.get(0).size()) {
            int rightValue = forest.get(currentPosition[1]).get(currentPosition[0] + 1);
            if (rightValue - currentValue < minDistance && rightValue - currentValue > 0) {
                minDistance = rightValue - currentValue;
                nextPosition = new int[2];
                nextPosition[0] = currentPosition[0] + 1;
                nextPosition[1] = currentPosition[1];
            }
        }
        if (currentPosition[1] - 1 >= 0) {
            int topValue = forest.get(currentPosition[1] - 1).get(currentPosition[0]);
            if (topValue - currentValue < minDistance && topValue - currentValue > 0) {
                minDistance = topValue - currentValue;
                nextPosition = new int[2];
                nextPosition[0] = currentPosition[0];
                nextPosition[1] = currentPosition[1] - 1;
            }
        }
        if (currentPosition[1] + 1 < forest.size()) {
            int bottomValue = forest.get(currentPosition[1] + 1).get(currentPosition[0]);
            if (bottomValue - currentValue < minDistance && bottomValue - currentValue > 0) {
                nextPosition = new int[2];
                nextPosition[0] = currentPosition[0];
                nextPosition[1] = currentPosition[1] + 1;
            }
        }

        return nextPosition;
    }
}
