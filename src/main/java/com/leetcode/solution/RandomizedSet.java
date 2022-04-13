package com.leetcode.solution;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {

    private final ArrayList<Integer> container = new ArrayList<>();

    public RandomizedSet() {
    }

    // 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false
    // 需要先检查是否存在 val
    // O(n)
    public boolean insert(int val) {
        System.out.println(container);
        if (contains(val)) {
            return false;
        }

        // O(1)
        container.add(val);
        return true;
    }

    // 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false
    // 需要先检查是否存在 val
    // O(n)
    public boolean remove(int val) {
        if (contains(val)) {
            // O(1)
            container.remove(new Integer(val));
            return true;
        }
        return false;
    }

    // O(1)
    public int getRandom() {
        int index = (int) (Math.random() * container.size());
        return container.get(index);
    }

    private boolean contains(int val) {
        // indexOf(val) >= 0 => O(n)
        return container.contains(val);
    }
}
