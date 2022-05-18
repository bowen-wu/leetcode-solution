package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 * 668. 乘法表中第k小的数
 */
public class FindKthNumber {
    public static void main(String[] args) {
        System.out.println(new FindKthNumber().findKthNumber(2, 3, 6));
    }

    // 暴力解法 => 找到所有的值，之后排序
    // 时间复杂度：O(m * n) + O(m * n)
    // 空间复杂度：O(m * n) + O(m * n)
    public int findKthNumber(int m, int n, int k) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                numberList.add(i * j);
            }
        }
        List<Integer> sortedNumberList = quickSort(numberList);
        return sortedNumberList.get(k - 1);
    }

    // 分治法(Divide and conquer)需要O(n)的额外空间
    public List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<Integer> left = new ArrayList<>(), pivot = new ArrayList<>(), right = new ArrayList<>();
        Integer pivotValue = list.get(0);
        for (Integer element : list) {
            if (element < pivotValue) {
                left.add(element);
            } else if (element.equals(pivotValue)) {
                pivot.add(element);
            } else {
                right.add(element);
            }
        }
        return Stream.of(quickSort(left), pivot, quickSort(right)).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
