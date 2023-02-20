# 排序算法

## 概述

1. 一般排序算法(以元素比较为基础) => **快速排序**、**归并排序**、**插入排序**、**冒泡排序**、堆排序
2. 特殊排序算法 => 基数排序、桶排序

## 循环不变式 for/while

循环不变式过程

1. 初始化 => 循环的第一次迭代之前循环不变式为真
2. 保持 => 如果循环的某次迭代之前它为真，那么下次迭代之前它仍为真 => 在从当前状态到下一个状态的过程中能得以保持
3. 终止 => 在循环终止时，不变式为我们提供了一个有用的性质，该性质有助于证明算法是正确的。如果程序可以在某种条件下终止，那么在终止的时候，就可以得到自己想要的正确结果

## [插入排序 Insertion Sort](https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F)

- 时间复杂度
    - Best => O(n) => 数组已经排序
    - Average => O(n^2) => 确定在什么位置插入元素 num，平均地数组中有一半元素大于 num，一半小于 num
    - Worse => O(n^2) => 数组反向排序
- 空间复杂度：O(1)

### 模板

```java
public class InsertionSort {
    public void sort(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }
    }
}
```

### 循环不变式

在 for 循环(循环变量为i)的每次迭代的开始，包含元素 nums[0, i - 1] 的子数组是有序的

## [冒泡排序 Bubble Sort](https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F)

- 核心想法 => 反复交换相邻的未按次序排列的元素
- 时间复杂度
    - Best => O(n)(改进后)/O(n^2)
    - Average=> O(n^2)
    - Worse => O(n^2)
- 空间复杂度：O(1)

### 模板

```java
public class BubbleSort {
    public void sort(int[] nums) {
        // 时间复杂度：O(n^2)
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int temp;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void sortRefine(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int length = nums.length;
        int temp;

        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 1; j < length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }
}
```

### 循环不变式

在 for 循环(循环变量为i)的每次迭代的开始，包含元素 nums[length - i - 1, length - 1] 的子数组是有序的

## [归并排序 Merge Sort](https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F)

- 核心想法 => 分治法(Divide and Conquer) => 找中点，之后分别排序，再合并两个有序数组 => **分成最小，然后两两比较合并**
- 时间复杂度：O(nlogn)
- 空间复杂度：O(n)
- 注意：**合并两个有序数组，剩余部分使用 while 循环**

### 模板1

```java
import java.util.Arrays;

public class MergeSort {
    public void sort(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            mergeTwoSortedArray(nums, start, mid, end);
        }
    }

    private void mergeTwoSortedArray(int[] nums, int start, int mid, int end) {
        // copy arrays
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i + start];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = nums[i + mid + 1];
        }

        // merge two sorted array
        int index = start;
        int first = 0;
        int second = 0;

        while (first < left.length && second < right.length) {
            if (left[first] < right[second]) {
                nums[index++] = left[first++];
            } else {
                nums[index++] = right[second++];
            }
        }

        // remaining
        while (first < left.length) {
            nums[index++] = left[first++];
        }

        while (second < right.length) {
            nums[index++] = right[second++];
        }
    }
}
```

### 模板2

```java
import java.util.Arrays;

public class MergeSort {
    public void sortTwo(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, temp, start, mid);
        mergeSort(nums, temp, mid + 1, end);
        mergeTwoSortedArray(nums, temp, start, mid, end);
    }

    private void mergeTwoSortedArray(int[] nums, int[] temp, int start, int mid, int end) {
        // merge two sorted array
        int index = start;
        int first = start;
        int second = mid + 1;

        while (first <= mid && second <= end) {
            if (nums[first] < nums[second]) {
                temp[index++] = nums[first++];
            } else {
                temp[index++] = nums[second++];
            }
        }

        // remaining
        while (first <= mid) {
            temp[index++] = nums[first++];
        }
        while (second <= end) {
            temp[index++] = nums[second++];
        }

        // copy
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
```

## 快速排序

- 核心想法 => 分治法(Divide and Conquer) => **通过划分调整大小关系**
- 时间复杂度
    - Best => O(nlogn) => 划分数组对半分 => T(n) = 2T(n/2) + O(n) => O(nlogn)
    - Average => O(nlogn) => 平衡划分，任何以常数比例的划分都会产生深度为 O(logn) 的递归树，其中每一层的代价都是 O(n) -> T(n) = T(kn) + T((1-k)n) + O(n)，其中
      0 < k < 1 -> O(nlogn)
    - Worse => O(n^2) => 划分两个数组分别为有 n - 1 个元素与0个元素 => T(n) = T(n - 1) + T(0) + O(n) -> O(n^2)
- 空间复杂度：O(1)

### 模板

```java
import java.util.Arrays;

public class QuickSort {
    public void sort(int[] nums) {
        // check input
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partitionTwo(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partitionTwo(int[] nums, int start, int end) {
        int pivot = start;
        int pivotValue = nums[pivot];

        while (start < end) {
            while (start < end && nums[end] >= pivotValue) {
                end--;
            }

            // find the first element that smaller than pivotValue
            nums[start] = nums[end];

            while (start < end && nums[start] <= pivotValue) {
                start++;
            }

            // find the first element that bigger than pivotValue
            nums[end] = nums[start];
        }

        nums[start] = pivotValue;
        return start;
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // j 是第一个小于 pivotValue 的位置
        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;

                // 说明i之前一定有元素大于 pivotValue，需要交换
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, j + 1, end);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### 分治法

1. 分解 => 将数组划分为两个(可能为空)子数组，使得前一个子数组中的每个元素都小于或等于 nums[pivot]，后一个都大于 nums[pivot]
2. 解决 => 递归的对两个子数组分别排序
3. 合并 => 由于子数组都是**原地排序不需要合并**

### 循环不变式

对于每一轮迭代开始时对于任意数组下标i都有：

- 若 start <= i <= pivot，则 nums[i] <= nums[pivot]
- 若 i == pivot，则 nums[i] == nums[pivot]
- 若 pivot < i <= end，则 nums[pivot] < nums[i]

### 期望为线性时间的快速选择算法 Quick Select

求数组 nums 中第 k 小的元素

- 将数组划分为两个(可能为空)子数组，使得前一个子数组中的每个元素都小于或等于 nums[index]，后一个都大于 nums[index]
- 检查 nums[index] 是否为第 k 小的元素
    1. index == k => 返回 nums[index]
    2. index > k => 第 k 小的元素落在**低**区
    3. index < k => 第 k 小的元素落在**高**区，并且已经知道有 index 个元素比 nums[index] 小

#### 模板

```java
public class QuickSelect {
    public int getKthSmallerElement(int[] nums, int k) {
        // check input
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivot = partition(nums, start, end);
        if (pivot == k - 1) {
            return nums[pivot];
        }
        if (pivot < k - 1) {
            // 高区
            return quickSelect(nums, pivot + 1, end, k);
        }

        // 低区
        return quickSelect(nums, start, pivot - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];
        int j = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivotValue) {
                j++;

                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }

        swap(nums, j + 1, end);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

## 知识点

1. 稳定 => 相同值元素的相对位置 => ` index1 < index2 && nums[index1] == nums[index2]  ` => 排序后 index1 仍然在 index2 之前
    - case: 3 1(1) 2 4 1(2) 6
    - 稳定 => 1(1) 1(2) 2 3 4 6
    - 不稳定 => 1(2) 1(1) 2 3 4 6
