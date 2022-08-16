package com.leetcode.solution.recurision.hanotaLcci.first;

import com.leetcode.solution.recurision.hanotaLcci.HanotaTemplate;

import java.util.List;

public class Hanota extends HanotaTemplate {
    @Override
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A == null || A.size() == 0) {
            return;
        }
        moveHanota(A.size(), A, C, B);
    }

    private void moveHanota(int n, List<Integer> origin, List<Integer> destination, List<Integer> temp) {
        if (n == 1) {
            int element = origin.remove(origin.size() - 1);
            destination.add(element);
            return;
        }
        moveHanota(n - 1, origin, temp, destination);
        destination.add(origin.remove(origin.size() - 1));
        moveHanota(n - 1, temp, destination, origin);
    }
}
