## 编辑距离

<https://leetcode.cn/problems/edit-distance/>

### 思路

1. 制表法
2. state => dp[i][j] 表示 word1 的 [0, i) 到 word2 的 [0, j) 的最小距离
3. status function => ` dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j - 1] : (Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1) `
4. condition => dp[0][0, len2] = [0, len2] dp[0, len1][0] = [0, len1]
5. solution => dp[len1][len2]
6. 对于传入字符串是 null 的判断

### 总结

1. 如果不等，应该是3个比较大小
