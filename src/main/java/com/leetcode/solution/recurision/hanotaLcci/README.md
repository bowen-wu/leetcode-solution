## 汉诺塔问题

<https://leetcode.cn/problems/hanota-lcci/>

### 思路

### 总结

| 问题行数    | 错误点                          | 正确写法                                         | 错误原因               |
|---------|------------------------------|----------------------------------------------|--------------------|
| 15 & 19 | target.push(origin.remove()) | target.add(origin.remove(origin.size() - 1)) | API 不熟，没有 IDEA 的帮助 |
| 4       | A.size == 0                  | A.size() == 0                                | API 不熟，没有 IDEA 的帮助 |

```java
class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // 思路：如果只有一个 A -> C 
        if (A.size() == 0) {
            return;
        }
        hanotaRecursion(A.size(), A, C, B);
    }

    private void hanotaRecursion(int n, List<Integer> origin, List<Integer> target, List<Integer> buffer) {
        if (n < 1) {
            throw new IllegalArgumentException("The param n is invalid!");
        }
        if (n == 1) {
            target.add(origin.remove(origin.size() - 1));
            return;
        }
        hanotaRecursion(n - 1, origin, buffer, target);
        target.add(origin.remove(origin.size() - 1));
        hanotaRecursion(n - 1, buffer, target, origin);
    }
}
```
