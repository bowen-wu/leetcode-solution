# 动态规划

## 概述

- Dynamic Programming => 动态规划
- Programming => 制表法

## Fibonacci

求 Fibonacci 第 n 项

### 递归

缺点：存在重复计算

```java
public class Fibonacci {
  // 时间复杂度：O(1.618^n)
  public int fibonacci(int n) {
    if (n < 2) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
```

### 解决重复计算

- 核心想法 => 空间换时间
- 记忆化搜索 => 通过开辟额外存储空间，将计算过的值存储起来
- 记忆化搜索的本质就是动态规划，**动态规划就是解决了重复计算的搜索**
- 动态规划实现方式 =>
    1. 记忆化搜索
    2. 循环

### 自顶向下 DP

```java
import java.util.Arrays;

public class Fibonacci {
  // 时间复杂度：O(n)
  public int fibonacci(int n) {
    if (n < 2) {
      return n;
    }
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    memo[0] = 0;
    memo[1] = 1;

    return fibonacci(n, memo);
  }

  private int fibonacci(int n, int[] memo) {
    if (memo[n] != -1) {
      return memo[n];
    }
    int result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
    memo[n] = result;
    return result;
  }
}
```

### 自底向上 DP

```java
public class Fibonacci {
  // 时间复杂度：O(n)
  public int fibonacci(int n) {
    if (n < 2) {
      return n;
    }
    int[] memo = new int[n + 1];
    memo[0] = 0;
    memo[1] = 1;

    for (int i = 2; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    }

    return memo[n];
  }
}
```

### 滚动数组

- fib(10) 只与 fib(9) 和 fib(8) 有关
- 自顶向下和自底向上都可以进行空间上的优化 => 滚动数组
- 滚动数组 => **对数组的下标进行特殊处理，使每一次操作仅保留若干有用信息，对新的元素进行取模存储，看上去数组的空间被滚动地利用**
- 达到了状态压缩储存的作用
- DP 是一个自底向上的扩展过程，常常用到的是连续地解，而每次用到的只是解集中的最后几个解，滚动数组形式能大大减少内存开销

```java
public class Fibonacci {
  // 时间复杂度：O(n)
  public int fibonacci(int n) {
    if (n < 2) {
      return n;
    }
    int associationNumber = 2;
    int[] memo = new int[associationNumber];
    memo[1] = 1;

    for (int i = 2; i <= n; i++) {
      memo[i % associationNumber] = memo[(i - 1) % associationNumber] + memo[(i - 2) % associationNumber];
    }

    return memo[n % associationNumber];
  }
}
```

## 动态规划

- Dynamic Programming 是通过组合子问题的解来求解原问题的
- DP 应用于**子问题重叠**的情况 => 子问题的求解是递归的，不同子问题具有公共的子子问题
- 不同于分治算法，分治算法会反复求解公共子子问题
- DP 对每个子子问题只求解一次，将其结果保存在表格里(programming 指的就是一种表格法)，从而无需重复计算子子问题
- DP 通常用来**求解最优化问题**

### 设计 DP

1. 刻画一个最优解的结构特征 => 最优子结构性质 => 问题的最优解由相关子问题的最优解组合而成，而这些子问题可以独立求解
2. 递归地定义最优解的值 => **状态转移方程**
3. 计算最优解的值，通常采用**自底向上**的方法
4. 利用计算出的信息构造一个最优解

### 设计 DP 模板

1. 定义状态(State) => 刻画一个最优解的结构特征
2. 定义状态转移方程(Function) => 状态之间的联系与状态转移 => 核心难点
3. 初始条件与边界条件(Condition) => 基本条件是什么？最小状态是什么？
4. 最优解求解(Solution)

#### Fibonacci

1. state => f(n) 表示斐波那契数列的第 n 项
2. status function => f(n) = f(n - 1) + f(n -2) => n >= 2
3. condition => f(0) = 0，f(1) = 1
4. solution => 求 f(n)

## 应用场景

通常用于最优化问题

1. 求方案总数
2. 方案可行性
3. 求最优化解
4. **DP 不适合输出所有可行方案的题目**

### 适合 DP 求解的条件

1. 最优子结构性质 => 一个问题的最优解包含其子问题的最优解
2. 子问题的**重叠性** => 问题的递归算法会反复求解相同的子问题，而不是一直生成新的子问题
3. **无后效性** => 对于一个**确定的状态**，不必关心这个状态是怎么出现的，也不必考虑这个状态的前一个状态是什么 => case: fibonacci，f(n) 是一个确定的状态，不需要关心第 n 项是怎么来的，也不考虑 f(n - 1) 的状态。但是**不关心不代表不依赖**

### DP vs 贪心

- 贪心 => 每一步的最优解(局部最优)，不一定是全局最优
- DP => 全局最优

## 子问题图

- DP 问题中子问题之间的依赖关系图
- 有向图，每个顶点唯一对应一个子问题
- 若求解子问题 x 的最优解需要直接用到子问题 y 的最优解，那么在子问题图中就会有一条从子问题 x 顶点到子问题 y 顶点的有向边

### 结论

1. 子问题图 G = (V, E) 规模可确定 DP 的时间复杂度，算法运行时间通常与顶点和边的数量呈**线性关系**
2. **自底向上** DP 按**逆拓扑序列**处理子问题顶点
3. **自顶向下** DP 按照 **DFS 顺序**处理子问题顶点

## 单序列 DP

### 斐波那契系列

- 题目特点 => 找到递归公式，然后以 DP 的方式求递推关系
- 典型题目 =>
    1. [斐波那契数](https://leetcode.cn/problems/fibonacci-number/)
    2. [第 N 个泰波那契数](https://leetcode.cn/problems/n-th-tribonacci-number/)
    3. [爬楼梯](https://leetcode.cn/problems/climbing-stairs/)
    4. [使用最小花费爬楼梯](https://leetcode.cn/problems/min-cost-climbing-stairs/)

### 打家劫舍系列

- 题目特点 => 求解限制连续取相邻元素下的最大和
- 解题要点 => DP 的最后一步的选择依赖于前面的选择
- 典型题目 =>
    1. [打家劫舍](https://leetcode.cn/problems/house-robber/)
    2. [打家劫舍II](https://leetcode.cn/problems/house-robber-ii/)
    3. [删除并获得点](https://leetcode.cn/problems/delete-and-earn/)

### 最长上升子序列（LIS）系列

- 题目特点 => 经典单序列 DP 问题，经典状态设计
- 解题要点 => **dp[i] 表示以 nums[i] 结尾的最长递增子序列长度**
- 典型题目 =>
    1. [最长递增子序列](https://leetcode.cn/problems/delete-and-earn/)
    2. [最长递增子序列的个数](https://leetcode.cn/problems/number-of-longest-increasing-subsequence/)
    3. [俄罗斯套娃信封问题](https://leetcode.cn/problems/russian-doll-envelopes/)

### 最大子数组和系列

- 题目特点 => 求连续区间的最值问题而不能间断
- 解题要点 => **dp[i] 围绕以 nums[i] 结尾定义**
- 典型题目 =>
    1. 最大子数组和
    2. 乘积最大子数组
    3. 最大子矩阵

### 带维度（状态）的单序列

- 题目特点 => 在单序列的基础上，子问题还与维度 k 有关，k 可能是颜色、长度、个数等
- 解题要点 => 状态定义为 dp[i][k]，i 和 k 分别为两个不同维度的单序列 dp 问题
- 典型题目 =>
    1. 粉刷房子I/II
    2. 最大平均值和的分组
    3. 买股票系列

## 双序列 DP

- 题目特点 => 输入序列由两个单序列组成
- 解题要点 =>
    1. 用 i，j 两个变量分别代表第一个串和第二个串的位置
    2. dp[i][j] 代表第一串 [0...i]，第二串 [0...j]时，原问题的解
    3. **推导 dp[i][j] 仅与 dp[i - 1][j]、dp[i][j - 1] 和 dp[i - 1][j - 1] 有关**
- 典型题目 =>
    - 最长公共子序列 LCS 系列
    - 字符串匹配系列（编辑距离）

## 二维矩阵 DP - 无额外状态系列

- 题目特点 => 输入为二维矩阵，常与路径方案有关
- 解题要点 =>
    1. 用 i，j 两个变量分别代表横纵坐标
    2. dp[i][j] 代表行维度考虑 [0, i]，列维度考虑 [0, j] 原问题的解
    3. **推导 dp[i][j] 常与 dp[i - 1][j]，dp[i][j - 1]，dp[i - 1][j - 1] 有关**
    4. 二维矩阵 DP 问题状态推导方向与双序列 DP 问题大致相同，但含义不同，且求 dp[i][j] 时所需的子问题的变化相对较多
- 典型题目
    - 不同路径I/II
    - 三角形最小路径和
    - 最小路径和
    - 下降路径最小和
    - 最大正方形
    - 地下城游戏

## 背包 DP - Knapsack DP

- NP 完全问题
- 基本描述 => 有 n 种物品，每种物品 i 都有自己的重量 w 和价值 v，在限定的总重量内选择物品使得物品的总价值最高
- 背包问题分类
    1. 01背包
    2. 完全背包
    3. 多重背包
- [参考资料 - 背包九讲](https://github.com/tianyicui/pack/blob/master/V2.pdf)

### 01 背包

- 问题：有 n 种物品，物品i的体积为V<sub>i</sub>，价值为W<sub>i</sub>，每种物品只有一个，可选择放入背包，求解在背包体积V下可获取的最大价值
- state => **dp[i][j] 表示前 i 个物品占用了 j 的空间能获得的最大价值**
- status function => **第 i 个物品拿或者不拿** => **dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i])**
- condition =>
    1. 恰好装满 => dp[i][0] == 0，其余 Integer.MIN_VALUE
    2. 无要求
- solution => max(dp[i][j])
- 典型题目 => 分割等和子集

#### 空间优化

1. 滚动数组 => 两个数组
2. 一个数组 => 一维问题 => **二维数组空间优化到两个数组，之后继续空间优化到一个数组**
    - state => dp[j] 占用了 j 空间能获得的最大价值
    - status function => **dp[j] = max(dp[j], dp[j - v[i]] + w[i])** => **需要从后往前计算(j => V -> 0)**
    - condition => 无
    - solution => max(dp[i])

### 完全背包

- 问题：有 n 种物品，物品 i 的体积为 V<sub>i</sub>，价值为 W<sub>i</sub>，每种物品有无限个，求解在背包体积 V 下可获取的最大价值
- state => dp[i][j] 表示前 i 个物品占用 j 的空间所能获得的最大价值
- status function =>
    1. dp[i][j] = max(dp[i][j - k * v[i]] + k * w[i]) => 对于第 i 个物品，取 0、1、2、3、...、V/V<sub>i</sub> 件 => O(k * n * n)
    2. **取2件 == 取1件 + 加选1件** => dp[i][j] = max(dp[i - 1][j], dp[i][j - v[i]] + w[i])
    3. 01背包的一维问题(j空间能获取的最大价值) => dp[j] = dp[j - v[i]] + w[i]
- solution => max(dp[i][j])
- 典型题目 =>
    1. 零钱兑换I/II
    2. 组合总和IV

#### 总结

1. **物品**只能取一次 => 01背包
2. **物品**能够无限次取 => 完全背包
3. 顺序不同的序列是**相同**的组合 => 先遍历硬币
4. 顺序不同的序列是**不同**的组合 => 先遍历金额

### 多重背包

- 问题：有 n 种物品，物品 i 的体积为 V<sub>i</sub>，价值为 W<sub>i</sub>，每种物品有 C<sub>i</sub> 个，求解在背包体积 V 下可获取的最大价值
- state => dp[i][j] 表示前 i 个物品占用 j 的空间所能获得的最大价值
- status function => dp[i][j] = max(dp[i - 1][j - kv[i]] + kw[i])，其中 0 <= k <= c[i]
- solution => max(dp[i][j])

## 知识点

1. DP 定位技巧
2. 矩形 => 使用**左上角**坐标和**右下角**坐标
3. 正方形 => 使用**右下角**坐标
