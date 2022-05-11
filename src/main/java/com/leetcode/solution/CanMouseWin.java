package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/cat-and-mouse-ii/
 * 1728. 猫和老鼠 II
 */
public class CanMouseWin {
    public static void main(String[] args) {
        System.out.println(new CanMouseWin().canMouseWin(new String[]{".M...", "..#..", "#..#.", "C#.#.", "...#F"}, 3, 1));
    }

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        List<Integer> catPosition = new ArrayList<>();
        List<Integer> mousePosition = new ArrayList<>();
        List<Integer> foodPosition = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            String currentLine = grid[i];
            if (currentLine.contains("C")) {
                // 🐱的位置
                catPosition.add(i);
                catPosition.add(currentLine.indexOf("C"));
            }
            if (currentLine.contains("M")) {
                // 🐭的位置
                mousePosition.add(i);
                mousePosition.add(currentLine.indexOf("M"));
            }
            if (currentLine.contains("F")) {
                // 🍛的位置
                foodPosition.add(i);
                foodPosition.add(currentLine.indexOf("F"));
            }
        }

        List<List<Integer>> catToFoodPathList = getPathList(catPosition, foodPosition, grid, catJump);
        List<List<Integer>> mouseToFoodPathList = getPathList(mousePosition, foodPosition, grid, mouseJump);

        int minMouseStep = mouseToFoodPathList.size();
        int minCatStep = catToFoodPathList.size();
        boolean mouseCatchFood = mouseToFoodPathList.get(minMouseStep - 1).get(0).equals(foodPosition.get(0)) && mouseToFoodPathList.get(minMouseStep - 1).get(1).equals(foodPosition.get(1));

        boolean catEatMouse = false;
        for (int i = 0; i < Math.min(minCatStep, minMouseStep); i++) {
            if (catToFoodPathList.get(i).get(0).equals(mouseToFoodPathList.get(i).get(0)) && catToFoodPathList.get(i).get(1).equals(mouseToFoodPathList.get(i).get(1))) {
                catEatMouse = true;
                break;
            }
        }

        return minMouseStep < minCatStep && minMouseStep < 1000 && !catEatMouse && mouseToFoodPathList.get(minMouseStep - 1).get(0).equals(foodPosition.get(0)) && mouseToFoodPathList.get(minMouseStep - 1).get(1).equals(foodPosition.get(1));
    }


    public List<List<Integer>> getPathList(List<Integer> sourcePosition, List<Integer> targetPosition, String[] map, int jumpStep) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(sourcePosition);
        int sourceX = sourcePosition.get(0);
        int targetX = targetPosition.get(0);
        int sourceY = sourcePosition.get(1);
        int targetY = targetPosition.get(1);
        if (sourceX == targetX && sourceY == targetY) {
            return result;
        }

        int horizontalDistance = Math.abs(targetY - sourceY);
        int verticalDistance = Math.abs(targetX - sourceX);
        int minHorizontalMoveStep = Math.min(jumpStep, horizontalDistance);
        int minVerticalMoveStep = Math.min(jumpStep, verticalDistance);

        if (sourceX >= targetX && sourceY < targetY) {
            // sourceX >= targetX && sourceY < targetY
            // 右上 -> 第一象限
            // 走 jumpStep 步
            if (sourceX == targetX && map[sourceX].substring(sourceY, sourceY + minHorizontalMoveStep + 1).contains("#") && minVerticalMoveStep == 0) {
                return new ArrayList<>();
            }
            if (!map[sourceX].substring(sourceY, sourceY + minHorizontalMoveStep + 1).contains("#")) {
                // 向右移动
                move(targetPosition, map, result, sourceX, sourceY, 'R', minHorizontalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'T')) {
                // 向上移动
                move(targetPosition, map, result, sourceX, sourceY, 'T', minVerticalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'B')) {
                // 向下移动
                move(targetPosition, map, result, sourceX, sourceY, 'B', minVerticalMoveStep, jumpStep);
            } else if (!map[sourceX].substring(sourceY - minHorizontalMoveStep - 1, sourceY).contains("#")) {
                // 向左移动
                move(targetPosition, map, result, sourceX, sourceY, 'L', minHorizontalMoveStep, jumpStep);
            }
            return result;
        }
        if (sourceX > targetX && sourceY >= targetY) {
            // sourceX > targetX && sourceY >= targetY
            // 左上 -> 第二象限
            if (sourceY == targetY && !canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'T') && minHorizontalMoveStep == 0) {
                return new ArrayList<>();
            }
            if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'T')) {
                // 向上移动
                move(targetPosition, map, result, sourceX, sourceY, 'T', minVerticalMoveStep, jumpStep);
            } else if (!map[sourceX].substring(sourceY - minHorizontalMoveStep - 1, sourceY).contains("#")) {
                // 向左移动
                move(targetPosition, map, result, sourceX, sourceY, 'L', minHorizontalMoveStep, jumpStep);
            } else if (!map[sourceX].substring(sourceY, sourceY + minHorizontalMoveStep + 1).contains("#")) {
                // 向右移动
                move(targetPosition, map, result, sourceX, sourceY, 'R', minHorizontalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'B')) {
                // 向下移动
                move(targetPosition, map, result, sourceX, sourceY, 'B', minVerticalMoveStep, jumpStep);
            }
            return result;
        }
        if (sourceX <= targetX && sourceY > targetY) {
            // sourceX <= targetX && sourceY > targetY
            // 左下 -> 第三象限
            if (sourceX == targetX && map[sourceX].substring(sourceY - minHorizontalMoveStep - 1, sourceY).contains("#") && minVerticalMoveStep == 0) {
                return new ArrayList<>();
            }
            if (!map[sourceX].substring(sourceY - minHorizontalMoveStep - 1, sourceY).contains("#")) {
                // 向左移动
                move(targetPosition, map, result, sourceX, sourceY, 'L', minHorizontalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'B')) {
                // 向下移动
                move(targetPosition, map, result, sourceX, sourceY, 'B', minVerticalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'T')) {
                // 向上移动
                move(targetPosition, map, result, sourceX, sourceY, 'T', minVerticalMoveStep, jumpStep);
            } else if (!map[sourceX].substring(sourceY, sourceY + minHorizontalMoveStep + 1).contains("#")) {
                // 向右移动
                move(targetPosition, map, result, sourceX, sourceY, 'R', minHorizontalMoveStep, jumpStep);
            }
            return result;
        }
        if (sourceX < targetX && sourceY <= targetY) {
            // 第四象限
            if (sourceY == targetY && !canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'B') && minHorizontalMoveStep == 0) {
                return new ArrayList<>();
            }
            if (!map[sourceX].substring(sourceY, sourceY + minHorizontalMoveStep + 1).contains("#")) {
                // 向右移动
                move(targetPosition, map, result, sourceX, sourceY, 'R', minHorizontalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'B')) {
                // 向下移动
                move(targetPosition, map, result, sourceX, sourceY, 'B', minVerticalMoveStep, jumpStep);
            } else if (!map[sourceX].substring(sourceY - minHorizontalMoveStep - 1, sourceY).contains("#")) {
                // 向左移动
                move(targetPosition, map, result, sourceX, sourceY, 'L', minHorizontalMoveStep, jumpStep);
            } else if (canVerticalMove(sourceX, sourceY, minVerticalMoveStep, map, 'T')) {
                // 向上移动
                move(targetPosition, map, result, sourceX, sourceY, 'T', minVerticalMoveStep, jumpStep);
            }
            return result;
        }
        return result;
    }

    private boolean canVerticalMove(int sourceX, int sourceY, int minVerticalMoveStep, String[] map, char direction) {
        boolean canVerticalMove = true;
        int currentXIndex = sourceX;
        while (Math.abs(sourceX - currentXIndex) < minVerticalMoveStep) {
            if (direction == 'T') {
                currentXIndex--;
            } else {
                currentXIndex++;
            }
            if (map[currentXIndex].charAt(sourceY) == '#') {
                // 不能向上移动
                canVerticalMove = false;
                break;
            }
        }
        return canVerticalMove;
    }


    private void move(List<Integer> targetPosition, String[] map, List<List<Integer>> result, int sourceX, int sourceY, char direction, int moveStep, int jumpStep) {
        List<Integer> positionAfterMoved = new ArrayList<>();
        if (direction == 'T') {
            positionAfterMoved.add(sourceX - moveStep);
            positionAfterMoved.add(sourceY);
        }
        if (direction == 'B') {
            positionAfterMoved.add(sourceX + moveStep);
            positionAfterMoved.add(sourceY);
        }
        if (direction == 'L') {
            positionAfterMoved.add(sourceX);
            positionAfterMoved.add(sourceY - moveStep);
        }
        if (direction == 'R') {
            positionAfterMoved.add(sourceX);
            positionAfterMoved.add(sourceY + moveStep);
        }

        result.addAll(getPathList(positionAfterMoved, targetPosition, map, jumpStep));
    }
}
