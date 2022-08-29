# 递归

## 概述

- 学术定义 => 在数学和计算机科学中，递归指由一种或多种简单的基本情况定义的一类对象或方法，并规定其他所有情况都能被还原为其基本情况
- 递归 => 在函数的定义中使用函数自身的方法

## 解决问题

1. 拆解成更小的问题
2. 求解小问题
3. 利用小问题的结果解决原来的问题
4. 如果小问题和原问题相似只是规模不同，那么这就是递归问题

## [数学归纳法](https://zh.wikipedia.org/wiki/%E6%95%B0%E5%AD%A6%E5%BD%92%E7%BA%B3%E6%B3%95)

- 证明一个给定的陈述
- 数学归纳法解题过程
    1. 验证n取第一个自然数时成立
    2. 假设 n = k 时成立，然后以验证的条件和假设的条件作为论证的依据进行推导，在接下来的推导过程中不能直接将 n = k + 1 带入假设的原式中去
    3. 总结表述

## 递归三要素

1. 拆解寻找子问题 => 得到**递归公式**
2. 最小子问题 => 解决最小子问题是指可以直接得到答案，并不需要递归计算
3. 递归终止退出条件