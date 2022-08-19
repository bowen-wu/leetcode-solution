package com.leetcode.solution.recurision.hanotaLcci.second;

import com.leetcode.solution.recurision.hanotaLcci.HanotaTemplate;

import java.util.List;

public class Hanota extends HanotaTemplate {
    @Override
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // 思路：如果只有一个 A -> C
        if (A.size() == 0) {
            return;
        }
        hanotaRecursion(A.size(), A, C, B);
    }

    private void hanotaRecursion(int n, List<Integer> origin, List<Integer> target, List<Integer> buffer) {
        if (n < 1) {
            throw new IllegalArgumentException("The param n is invalid!");
        }
        if (n == 1) {
            target.add(origin.remove(origin.size() - 1));
            return;
        }
        hanotaRecursion(n - 1, origin, buffer, target);
        target.add(origin.remove(origin.size() - 1));
        hanotaRecursion(n - 1, buffer, target, origin);
    }
}
