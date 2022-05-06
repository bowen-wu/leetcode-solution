package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 * 933. 最近的请求次数
 * 初步做数据类型选用了 Array
 * 官方数据类型选用了 Queue
 * 数据是**递增**的
 * 此时 Array vs Queue
 * Array Queue 两种数据类型如何做抉择？ => **递增时可以选用 Queue**
 */
public class RecentCounter {
    private final LinkedList<Integer> pingTimeList;

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(2));
        System.out.println(recentCounter.ping(3));
        System.out.println(recentCounter.ping(3000));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(3004));
        System.out.println(recentCounter.ping(3010));
    }

    public RecentCounter() {
        this.pingTimeList = new LinkedList<>();
    }

    // 时间复杂度：O(1)
    // 空间复杂度：O(L) 其中 LL 为队列的最大元素个数
    public int ping(int t) {
        pingTimeList.add(t);
        while (pingTimeList.getFirst() < t - 3000) {
            pingTimeList.poll();
        }
        return pingTimeList.size();
    }
}
