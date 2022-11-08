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

### 总结

| 问题行数 | 错误点          | 正确写法 | 错误原因 |
|------|--------------|------|------|
| 20   | currentLIS++ | 比较更新 | 思路   |

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 看成两个 LIS => 先排序0, 如果相等，按1倒排
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] memo = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int currentLIS = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    currentLIS = Math.max(currentLIS, memo[j] + 1);
                }
            }

            memo[i] = currentLIS;
        }

        int result = memo[0];
        for (int i = 1; i < memo.length; i++) {
            result = Math.max(result, memo[i]);
        }
        return result;
    }
}
```
