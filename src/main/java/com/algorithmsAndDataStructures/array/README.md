# 数组与数组列表

## 数组

- 数组 => 由相同类型的元素的集合所组成的结构
- 分配一块连续的内存来存储元素
- 利用元素的索引可以计算出该元素对应的存储地址

### 特性

- 在内存中为**连续空间**
- 储存在数组中的元素是相同类型的
- 通过 index 获取数组元素的时间复杂度是 O(1)

### 操作

- 增 =>
- 删 =>
- 改 =>
- 查 =>

### 沟通问题

1. 什么类型的数组
2. 是否有重复元素
3. 是否有序
4. 怎么输出 => 是全部结果还是任意结果
6. 函数定义
    - 输入参数(几个，类型)
    - 输出(返回值)
    - 名字 => 具体意义
7. 检查输入参数

## K-Sum

1. 排序
2. 尝试遍历第一个数，将问题转化为 k-1 Sum
3. 时间复杂度
    - 2-Sum => O(nlogn) + O(n) => O(nlogn)
    - 3-Sum => O(nlogn) + O(n^2) => O(n^2)
    - 4-Sum => O(nlogn) + O(n^3) => O(n^3)
    - k-Sum => O(nlogn) + O(n^(k-1)) => O(n^(k-1))

## 交换元素

引入中间变量

```
public void swap(int[] nums, int firstIndex, int secondIndex) {
   int temp = nums[firstIndex];
   nums[firstIndex] = nums[secondIndex];
   nums[secondIndex] = temp;
}
```

## 数组预处理技巧 - 前缀和

- 快速计算一个区间内的元素之和
- prefixSum[i] = $\sum_{k=0}^{i-1}$nums[k],i$\not=$0
- prefixSum[0] == 0
- 前缀和数组(prefixSum) length == nums.length + 1
- **nums[i] == prefixSum[i + 1] - prefixSum[i]** => a<sub>n</sub> = S<sub>n</sub> - S<sub>n - 1</sub>
- **interval[i, j] = prefixSum[j + 1] - prefixSum[i]** => 从 i 到 j 的和 => S<sub>j</sub> - S<sub>i</sub> = a<sub>i +1</sub> + a<sub>i + 2</sub> + a<sub>i + 3</sub> + ... + a<sub>j</sub>

```
// 前缀和数组的长度为原数组长度加1
// 注意构造时 index 的取值范围
int[] prefixSum = new int[nums.length + 1];
for(int i = 0; i < nums.length; i++) {
   prefixSum[i + 1] = prefixSum[i] + nums[i];
}
```

## 数组列表 ArrayList

- 基于数组实现的**容量大小可动态变化**的数据结构
- 可以将很多数组操作的细节封装起来
- ` List<Integer> list = new ArrayList<>(); `
- get/set => O(1)
- add/remove/indexOf => O(n)

### ArrayList的实现

1. 定义属性字段
    - 在数组的基础上实现：储存数据信息 int data[]
    - 属性：data, size, capacity
2. 定义构造器实现
3. 定义方法

```java
public class MyArrayList<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int capacity;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("Capacity value must be positive");
        }

        this.elements = new Object[Math.max(capacity, DEFAULT_CAPACITY)];
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
    }

    // 方法 -> 增删改查

    /**
     * Add the element into array list by index.
     *
     * @param index element index
     * @param value element value
     */
    public void add(int index, T value) {
        rangeCheckForAdd(index);

        if (size == capacity) {
            resize(2 * capacity);
        }

        if (index < size) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
        }

        elements[index] = value;
        size++;

    }

    /**
     * Add in the last position
     *
     * @param value element value
     */
    public void add(T value) {
        add(size, value);
    }

    /**
     * Remove the element according index.
     *
     * @param index the element index
     * @return removed element
     */
    public T remove(int index) {
        rangeCheck(index);
        T toRemoved = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;

        return toRemoved;
    }

    // 删除所有值为 value 的元素？还是删除第一个？
    public void removeByValue(T value) {

    }

    /**
     * Set/Update element value by index.
     *
     * @param index    the element index
     * @param newValue the new value to set
     */
    public void set(int index, T newValue) {
        rangeCheck(index);
        elements[index] = newValue;
    }

    /**
     * Get element by index.
     *
     * @param index the element index
     * @return the element value
     */
    public T get(int index) {
        rangeCheck(index);
        return (T) elements[index];
    }

    /**
     * Get the index of first element equals to value.
     *
     * @param value
     * @return 第一个等于 value 的下标
     */
    public int indexOf(Object value) {

    }

    /**
     * Get the length of array list.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Determinate the array list is empty or not.
     *
     * @return the status.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("The index is invalid! The index: " + index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("The index for adding is invalid! The index: " + index);
        }
    }

    /**
     * Dynamic grow
     */
    private void resize(int newCapacity) {
        // 1. 扩成多大
        // 2. 原来元素怎么办
        Object[] newElement = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElement[i] = elements[i];
        }

        this.elements = newElement;
        this.capacity = newCapacity;
    }
}
```

## 知识点

1. 数组遍历考虑**越界**
