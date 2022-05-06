package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 * 933. 最近的请求次数
 */
public class RecentCounter {
    private final List<Integer> pingTimeList;

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
        this.pingTimeList = new ArrayList<>(3000);
    }

    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public int ping(int t) {
        pingTimeList.add(t);
        pingTimeList.removeIf(timestamp -> timestamp < pingTimeList.get(pingTimeList.size() - 1) - 3000);
        return pingTimeList.size();
    }
}
