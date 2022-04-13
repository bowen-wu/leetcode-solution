package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. O(1) 时间插入、删除和获取随机元素
 * 变长数组 + 哈希桶
 * HashMap {}
 * Array []
 * insert 1
 * => {1: 0} [1]
 * insert 4
 * => {1: 0, 4: 1} [1, 4]
 * insert 2
 * => {1: 0, 4: 1, 2: 2} [1, 4, 2]
 * remove 4
 * => 1. [1, 2, 2] {1: 0, 2: 2} 1
 * => 2. [1, 2] {1: 0, 2: 1}
 */
public class RandomizedSet {
    private final List<Integer> numbers;
    private final Map<Integer, Integer> indexMap;

    public RandomizedSet() {
        this.numbers = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    // 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false
    // 需要先检查是否存在 val
    // O(1)
    public boolean insert(int val) {
        if (indexMap.get(val) != null) {
            return false;
        }
        indexMap.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    // 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false
    // 需要先检查是否存在 val
    // O(1)
    public boolean remove(int val) {
        if (indexMap.get(val) == null) {
            return false;
        }
        int valIndex = indexMap.get(val);
        int lastIndex = numbers.size() - 1;
        int lastVal = numbers.get(lastIndex);
        numbers.set(valIndex, lastVal);
        indexMap.put(lastVal, valIndex);
        numbers.remove(lastIndex);
        indexMap.remove(val);
        return true;
    }

    // O(1)
    public int getRandom() {
        return numbers.get((int) (Math.random() * numbers.size()));
    }
}
