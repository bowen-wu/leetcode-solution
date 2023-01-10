## 最长公共子序列

<https://leetcode.cn/problems/longest-common-subsequence/>

## 思路

1. 制表法
2. state => dp[i][j] 表示第一串 [0, i) 和第二串 [0, j) 的 LCS
3. status function => dp[i][j] = text1[i] == text2[j] ? (dp[i - 1][j - 1] + 1) : Math.max(dp[i][j - 1], dp[i - 1][j])
4. condition => dp[0][0, j] = 0 + dp[0 - i][0] = 0;
5. solution => dp[len1][len2]

### 优化

1. 滚动数组
