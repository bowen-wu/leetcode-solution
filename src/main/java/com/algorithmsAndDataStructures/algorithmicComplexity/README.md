# 算法复杂度

## 概述

- 时间复杂度 => 执行算法所需要的计算工作量
- 空间复杂度 => 执行算法所需要的内存空间

## 复杂度描述符号

- 大 O 符号(Big O) => ` < ` => 一个算法的时间不会超过某个值
- 大$\Omega$符号(Big Omega) => ` > ` => 一个算法的时间超过某个值
- 大$\Theta$符号(Big Theta) => ` = ` => 一个算法的时间等于某个值

### 例子

T(n) = 4n<sup>2</sup> + 2n + 1

- n = 1 时 => 4n<sup>2</sup> 是 2n 的2倍大
- n = 500 时 => 4n<sup>2</sup> 是 2n 的1000倍大
- 2n对表达式值的影响可忽略不计
- 结论：**T(n) = O(n<sup>2</sup>)**

## 时间复杂度

- 在计算机科学中，算法的时间复杂度是一个函数，它定量描述了该算法的运行时间
- 以算法输入值规模n为自变量的函数 => T(n) = O(f(n))

### 时间复杂度比较

O(n!) > O(2<sup>n</sup>) > O(n<sup>3</sup>) > O(n<sup>2</sup>) > O(nlogn) > O(n) > O(logn) > O(1)

- O(n<sup>2</sup> + n) -> O(n<sup>2</sup>)
- O(logn + n) -> O(n)
- O(5 * 2<sup>n</sup> + 1000 * n<sup>100</sup>) -> O(2<sup>n</sup>)

### 评判时间复杂度

从数组中查找一个数

- 最好情况 => 目标值是数组第一个元素 => T(n) = O(1)
- 最坏情况 => 目标值是数组最后一个元素 => T(n) = O(n)
- **期望情况(平均情况) => T(n) = O(n)**

### 时间复杂度计算

#### 一般问题的时间复杂度计算

1. 基本操作的时间复杂度
    - 丢弃常数项
    - 丢弃次要项
2. 基本操作执行了多少次 => for/while循环：**执行了多少次，时间复杂度就是多少**
3. 复合操作 => 加或乘

##### 例子1

```
for(int i = 1; i < n; i++) {
   for(int j = i + 1; j <= n; j++) {
      System.out.println(j);
   }
}
```

T(n) = $\sum_{i=1}^{n-1}$ * $\sum_{j=i+1}^n$ * 1

1. 计算 $\sum_{j=i+1}^n$ * 1 => 共有多少项 => n - (i + 1) + 1 = n - i
2. $\sum_{i=1}^{n-1}$ * $\sum_{j=i+1}^n$ * 1 => $\sum_{i=1}^{n-1}$(n-i) => n-1 + n-2 + n-3 + ... + n-(n-1) => 1到n-1的和
3. T(n) = (1 + n - 1)(n - 1)/2 = n(n-1)/2
4. T(n) = O(n<sup>2</sup>)

##### 例子2

```
for(int i = 1; i <= n; i = i * 2) {
   for(int j = 1; j <= n; j++) {
      System.out.println(j);
   }
}
```

1. 第一个for循环 => 执行了t次 => 2<sup>t</sup> = n => t = log<sub>2</sub>n => O(logn)
2. 第二个for循环 => $\sum_{i=1}^{n}$ => O(n)

T(n) = logn * $\sum_{i=1}^{n}$ * 1 = O(nlogn)

#### 递归问题的时间复杂度计算

- 递归：在数学与计算机科学中，是指在函数的定义中使用函数自身的方法
- 一般表达(**子问题的规模是一样的**)：**T(n) = aT(n/b) + f(n)**
    - 问题规模为n
    - 分解为a个子问题，每个子问题的规模为n/b
    - a个子问题递归地求解，求解花费时间为T(n/b)
    - f(n)为问题分解和子问题解合并的**代价**

##### 求函数表达式

- 好处是准确直观，但很多时候计算复杂，无法求出
- 常见手段：累加/累乘/迭代/一切数学工具

e.g. T(n) = 2T(n/2) + cn

```
T(n) = 2T(n/2) + cn
     = 2(2T(n/4) + cn/2) + cn
     = 4T(n/4) + 2cn
     = 4(2T(n/8) + cn/4) + 2cn
     = 8T(n/8) + 3cn
        ...
     = nT(n/n) + tcn 
```

- 2<sup>t</sup> = n
- T(1) = O(1)
- T(n) = nO(1) + cnlog<sub>2</sub>n = nlogn

##### 递归树

- 递归树 => 递归问题用树描述迭代展开的过程
- 递归树是一颗节点带权值的树，初始的递归树只有一个节点，它的权标记为T(n)。然后按照递归树的迭代规则不断进行迭代，每迭代一次递归树就增加一层，直到树中不再含有权值为函数的节点(即叶子节点为T(1))
- 在得到递归树后，将树中每层中的代价求和，得到每层代价，然后将所有层的代价求和，得到所有层次的递归调用的总代价 => **需要求共多少层，即树的深度**

###### 画递归树步骤

**T(n) = aT(n/b) + f(n)**

1. 把根节点T(n)用根为f(n)(**代价**)、左节点为T(n/2)，右节点为T(n/2)的子树代替(以分解、合并子问题需要的代价为根，分解得到的子问题为叶的子树)
2. 把叶节点按照第一步的方式继续展开。T(n/2)用根为f(n/2)、左节点为T(n/4)，右节点为T(n/4)的子树代替
3. 反复按照第一步的方式迭代，每迭代一次递归树就增加一层，直到树中不再含有权值为函数的节点，即叶子节点为T(1)

##### 主定理

- **子问题规模不一样时不可使用** => **T(n) = aT(n/b) + n<sup>c</sup>**
- 比较log<sub>b</sub>a与c的大小
    1. log<sub>b</sub>a > c => T(n) = n<sup>log<sub>b</sub>a</sup>
    2. log<sub>b</sub>a == c => T(n) = n<sup>c</sup>logn
    3. log<sub>b</sub>a < c => T(n) = n<sup>c</sup>

###### 例子1 二分搜索

T(n) = T(n/2) + m

1. a = 1, b = 2, c = 0
2. log<sub>b</sub>a = log<sub>2</sub>1 = 0
3. n<sup>c</sup> = m => c = 0
4. T(n) = O(n<sup>c</sup>logn) = O(logn)

###### 例子2 归并排序

T(n) = 2T(n/2) + O(n)

1. a = 2, b = 2, c = 1
2. log<sub>b</sub>a = log<sub>2</sub>2 = 1
3. T(n) = O(n<sup>c</sup>logn) = O(nlogn)

##### 经验性结论

- 递归问题的时间复杂度通常(并不总是)看起来形如O(branches<sup>depth</sup>)
- branches => 递归分支的总数
- depth => 递归调用深度

##### 例子1

```
int calculate(int n) {
    if(n <= 0) {
        return 1;
    }
    return calculate(n - 1) + calculate(n - 1);
}


```

1. 递归树表达式 => T(n) = T(n-1) + T(n-1) + O(1) = 2T(n-1) + O(1)
2. 画树
    ```
                 1         ---> 1
                / \
               1   1       ---> 2
              / \ / \
             1  1 1  1     ---> 4
             ........
               T(1)
    ```
3. T(n) = 1 + 2 + 4 + 8 + ... + n = 等比数列前n项和 => S<sub>n</sub> = a<sub>1</sub> * (1 - q<sup>n</sup>) / (1 - q)
4. T(n) = O(2<sup>n</sup>)

##### 例子2

```
int fact(int n) {
    if(n < 0) {
        return -1;
    } else if(n == 0) {
        return 1;
    } else {
        return n * fact(n - 1);
    }
}
```

1. 递归树表达式 => T(n) = T(n - 1) + O(1)

##### 例子3

```
int sum(Node node) {
    if(node == null) {
        return 0;
    }
    return sum(node.left) + node.value + sum(node.right);
}
```

1. 设左子树占比 l，右子树占比 r，所以 l + r = 1
2. T(n) = T(ln) + T(rn) + O(1)

##### 例子4

```
int fib(int n) {
    if(n <= 0) return 0;
    else if(n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
}
```

1. T(n) = T(n - 1) + T(n - 2) + O(1) => O(2<sup>n</sup>) =>
   两侧树高度不同，根据[数学表达式](https://baike.baidu.com/item/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97/99145#%E9%80%9A%E9%A1%B9%E5%85%AC%E5%BC%8F)
   => O(1.618<sup>n</sup>)

```
void allFib(int n) {
    for(int i = 0; i < n; i++) {
        System.out.println(i + ": " + fib(i));
    }
}

int fib(int n) {
    if(n <= 0) return 0;
    else if(n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
}
```

1. T(n) = 1 + 2 + 4 + 8 + ... + 2<sup>n - 1</sup> => O(2<sup>n</sup>)

```
void allFib(int n) {
    int[] memo = new int[n + 1];
    for(int i = 0; i < n; i++) {
        System.out.println(i + ": " + fib(i, memo));
    }
}

int fib(int n, int[] memo) {
    if(n <= 0) return 0;
    else if(n == 1) return 1;
    else if(memo[n] > 0) return memo[n];
    
    memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    return memo[n];
}
```

1. T(n) = O(n)

##### 例子5

1. T(n) = nT(n - 1) + O(1) = n(n - 1)T(n - 2) + O(1) = n(n - 1)(n - 2)...2T(1) + O(1) = O(n!)

## 空间复杂度

- 时间复杂度不是衡量算法的唯一指标，还需要考虑空间复杂度
- 创建长度为n的数组，需要O(n)的空间
- 创建一个 m * n 的二位数组，需要O(m * n)的空间

