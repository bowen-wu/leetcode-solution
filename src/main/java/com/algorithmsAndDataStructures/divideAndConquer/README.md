# 分治法

## 概述

- Divide and Conquer

## 步骤

1. Divide(分解) => 将问题划分为一些子问题，子问题的形式和原问题一样，只是规模更小
2. Conquer(解决) => 递归地求解子问题。如果子问题规模足够小，则停止递归，直接求解
3. Combine(合并) => 将子问题的解组合成原问题的解

## 注意点

1. 分治问题是什么？
2. 子问题和原问题的关系是什么？

## 二叉树

- 二叉树问题的分治分别是指对左右子树递归的求解

### 二叉树分治法模板

```java
public class DivideAndConquer {
    public Result divideAndConquer(TreeNode root) {
        if (root == null) {
            // doSomething
            return null;
        }

        Result leftResult = divideAndConquer(root.left);
        Result rightResult = divideAndConquer(root.right);
        return conbine(leftResult, rightResult);
    }
}
```

## 分治法 vs 遍历法

- 都利用递归的思想
- 均属于广义 DFS
- 分治法可通过**函数返回值**得到答案
- 遍历法常常需要**全局变量** => 注意只传递，需要声明**全局**变量
