# 双指针

## 类型题目

1. 相遇型双指针
    - Two-Sum 类 => K-Sum类
    - 划分类
    - 灌水类
2. 同向型双指针
    - 快慢类
    - 窗口类 => 滑动窗口
3. 两双类

## 相遇型双指针

两根指针分别在头尾两端往中间移动

### Two-Sum 类

- 相等型 => Two-Sum/Three-Sum/K-Sum
- 不等型 => Closest/Smaller/Greater => **关注单一变化方向** => 破坏判断条件

### 划分类

- 核心 => 明确划分条件，知道何时进行元素交换
- 做法 => 参考快速排序的 partition2
- 典型题目
    1. 颜色分类
    2. 奇偶排序
    3. 字母排序
    4. 数组中第K大/小的元素
    5. 摆动排序

### 灌水类

- 核心 => 根据求面积条件判断指针移动，避免不必要计算
- 典型题目
    1. 盛最多水的容器
    2. 接雨水

## 同向型双指针

- 两根指针在同一端往相同的另一端移动
- 快慢类

### 窗口类问题

- 核心 => 滑动窗口，何时加一个元素，何时减一个元素
- 做法 => for/while 循环，关注窗口滑动条件，有时可能需要 map 记录窗口内元素

#### 模板

```java
public class SlidingWindow {
    public void slidingWindow(int[] nums) {
        // 时间复杂度 => 基本是 O(n)
        // check input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 可能需要 map 记录窗口内元素
        Map<Integer, Integer> map;

        // 同向性双指针
        int i;
        int j = 0;

        // 外层 for 循环，内存 while 循环为主体
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                // 窗口拓展条件
                if (condition) {
                    j++;

                    // 更新 j 状态，窗口内数据更新
                } else {
                    break;
                }
            }

            // 窗口收缩条件
            // 更新 i 的状态，窗口内数据更新
        }
    }
}
```
