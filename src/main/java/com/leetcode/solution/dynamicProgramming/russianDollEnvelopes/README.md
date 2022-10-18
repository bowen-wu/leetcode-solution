## 俄罗斯套娃信封问题

<https://leetcode.cn/problems/russian-doll-envelopes/>

### 思路

1. 将二维问题转化为一维 LIS 问题
2. 先按某一个维度排序 => 先按照 width 排序
3. 如果 width 相等，则按照 height 倒序排序 => case: [[2, 3],[5, 4], [6, 5], [6, 13], [7, 8]]
    1. height 升序 => [2, 3] -> [5, 4] -> [6, 5] -> [6, 13] -> [7, 8] => height LIS = 3, 4, 5, 13 => 是不对的
    2. height 倒序 => [2, 3] -> [5, 4] -> [6, 13] -> [6, 5] -> [7, 8] => height LIS = 3, 4, 5, 8
4. width 排序结束之后，width 就是升序的了
5. 此时只需要在 height 中找到 LIS(Longest Increasing Subsequence)
