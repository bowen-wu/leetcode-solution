## 两个字符串的最小ASCII删除和

<https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/>

### 思路

1. 制表法
2. state => dp[i][j] 表示 s1 从 [0, i) 和 s2 从 [0, j) 字符串相等所需删除字符的 ASCII 值
3. status
   function => ` dp[i][j] = s1.charAt(i - 1) == s2.charAt(j) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1)); `
4. condition =>
    - dp[i][0] = dp[i - 1][0] + s1.charAt(i)
    - dp[0][j] = dp[0][j] + s2.charAt(j)
5. solution => dp[len1][len2]
