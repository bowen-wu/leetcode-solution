package com.leetcode.solution.recurision.hanotaLcci.third;

import com.leetcode.solution.recurision.hanotaLcci.HanotaTemplate;

import java.util.List;

public class Hanota extends HanotaTemplate {
    @Override
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // 思路：A先把除了最后一个盘子之外的所有盘子通过C放到B上，之后把A的最后一个盘子放置到C上
        // 		之后B把除了最后一个盘子之外的所有盘子通过C放到A上，之后把B的最后一个盘子放置到C上
        if (A == null || A.size() == 0) {
            return;
        }
        move(A.size(), A, C, B);
    }

    private void move(int n, List<Integer> origin, List<Integer> target, List<Integer> buffer) {
        if (n == 1) {
            target.add(origin.remove(origin.size() - 1));
            return;
        }
        move(n - 1, origin, buffer, target);
        target.add(origin.remove(origin.size() - 1));
        move(n - 1, buffer, target, origin);
    }
}
