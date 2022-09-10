# 回溯法

## 概述

- Backtracking
- 回溯法实现 => DFS + 剪枝(跳过对某些一定不是解的子树)
- 可以把问题所有的解构造成一棵树 => n叉树 => **解空间树**
- 回溯法可以解决的问题 => **找所有方案**(不是个数)或者**找最优的具体方案**(非个数，非是否有最优方案)
- 回溯法路径 => 先自顶向下，即根节点向叶子节点移动，回溯的时候就是向祖先节点移动
- 回溯法是对隐式树(解空间树)的深度优先搜索算法
- 回溯法求问题**所有解** => 在解空间树中出发节点和终止节点一定都是根节点 => 要回溯到根，且根节点的所有可行的子树都要已被搜索遍才结束
- 回溯法求问题**任一个解** => 搜索到问题的一个解就可以结束

## 回溯法题目特点

- 大多数为 DFS 问题中的一维问题，少数为二叉树或者矩阵
- 大多数题目可分为组合问题和排列问题
- 两类问题
    1. 组合 => 求子集问题
    2. 排列 => 求排列问题

### 组合问题

1. 求所有满足条件的组合，本质是求**子集问题**
2. 解空间树结构为子集树
3. 时间复杂度：**O(2^n)**
4. 组合/子集问题的解中的元素常**与顺序无关**
5. 求解会挑选原数据集的部分元素而不是全部

### 排列问题

1. 求所有满足条件的排列
2. 解空间树结构为排列树
3. 时间复杂度：**O(n!)**
4. 排列问题的解中的元素常**与顺序相关**
5. 求解会挑选原数据集的全部元素

## 回溯法步骤

1. 针对所给问题，构造问题的解空间树
2. 从解空间树根节点出发利用 DFS 搜索解空间树，并在搜索过程中利用剪枝避免无效搜索
3. 当搜索到某一节点时，判断以该节点为根的子树是否可能包含问题的解
    - 如果一定不存在解 => 跳过对该子树的搜索并逐层向其祖先节点回溯
    - 如果可能存在解 => 进入该子树，继续利用 DFS 搜索

## 回溯法模板

1. 是否需要处理数据源 =>
    1. Sort => 解决**重复**和**大小关系**问题
    2. Set => 重复和优化查找
    3. Duplicated Work
2. 是否需要元素位置索引 => 组合问题一般需要，排列问题一般不需要
3. helper 函数定义 => 后面不确定的参数可以写出来再考虑
4. 递归退出条件
5. 单一解加入解集条件(Deep Copy)
6. 如何剪枝
7. 如何递归分解子问题到下一层
8. 如何回溯 => 一般是去掉单一解中的最后一个元素

```
public List<List<Integer>> backtrackingTemplate(int[] nums) {
    // 解集
    List<List<Integer>> result = new ArrayList<>();

    // check input
    if (nums == null || nums.length == 0) {
        return result;
    }

    // 单一解
    List<Integer> list = new ArrayList<>();

    // 排序 => 解决重复和大小关系问题 => 非必须
    // Arrays.sort(nums);

    // 计算解集 => 把单一解放入解集中 => 解集 + 单一解 + 数据源
    helper(result, list, nums[, ?]);
    return result;
}

private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos [, ?]) {
    // 递归退出条件
    if (condition xx) {
        return;
    }

    // 单一解何时加入解集中 => deep copy
    if (condition xx) {
        result.add(new ArrayList(list));
    }
    
    // 剪枝
    if (condition xx) {
        // doSomething
        return;
    }

    // 递归分解子问题，到下一层 => 可能要考虑剪枝
    for (sub: total-subs) {
        if (condition xx) {
            // 剪枝
            break; // or continue
        }
        list.add(element);
        help(result, list, nums, ?);
        
        // 何时回溯 + 怎么回溯 => 每一次的 add 之后都紧紧跟随一次的 remove
        list.remove(list.size() - 1);
    }
}
```

## 记忆化搜索

避免重复计算，开辟内存，将计算过的结果保存

```
public List<String> backtrackingWithMemorySearchTemplate(String s) {
    // check input
    if (s == null || s.length() == 0) {
        return new ArrayList<>();
    }

    // 处理源数据 => 非必须
    //     1. 排序 => 解决重复和大小关系问题 
    //     2. Set 去重 => 优化查找 =>  https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/backtrackingWithMemorySearch/wordBreak/first/WordBreak.java#L23
    //     3. 优化 Duplicate Work => https://github.com/bowen-wu/leetcode-solution/blob/master/src/main/java/com/leetcode/solution/backtrackingWithMemorySearch/palindromePartitioning/first/Partition.java#L24
    // Arrays.sort(nums);
    // Set<String> set = new HashSet<>(); 
    
    // 创建记忆化搜索空间 => int[] Map<Integer, <结果类型>> ... => 数组考虑初始化
    // 类型 == position -> List<String>(结果类型)
    <类型> memo = new <类型>
    
    return helper(memo, s, 0[, ?]);
}

private List<String> helper(<类型> memo, String s, int position [, ?]) {
    // case: memo[position] memo.containsKey(position) => 一般使用 position 作为 key，可以直接获取结果
    // 缓存如果使用数组，要先 check 是否越界
    if (命中缓存) {
        return <缓存结果>;
    }
    
    // 构造结果
    List<String> result = new ArrayList<>();
    
    // 递归退出条件
    if (condition xx) {
        return result;
    }
    
    // 判断 [position, s.length() - 1] 是否是一个结果
    if (s.substring(position) is result) {
        result.add(s.substring(position));
    }
    
    // 递归分解子问题，到下一层 => 可能要考虑剪枝
    // 从后向前遍历，可以最大可能利用缓存
    for (int i = s.length() - 1; i >= position; i--) {
        // 阶段性结果
        String substring = s.substring(position, i + 1);
        if (condition xx) {
            // 剪枝
            continue; // or break 
        }
        List<String> next = help(memo, s, i + 1[, ?]);
        
        // 构造单一结果 => substring 和 item 结合
        for (String item : next) {
            result.add(substring + item);
        }
    }
    
    // 更新 memo
    memo[position] = result;
    return result;
}
```

### 用途

1. 回溯法
2. 动态规划

### 核心点

1. 如何构造记忆化搜索
2. 何时使用记忆化搜索的值 => 如何通过记忆化搜索直接返回结果
3. 何时更新记忆化搜索的值

## 知识点

1. 如何判断一个元素是否访问过 => ` boolean[] visited = new boolean[nums.length]; `
2. String.charAt(i) == 'x' 效率大于 String.startWith("x")
