## 反转字符串

<https://leetcode.cn/problems/reverse-string/>

### 总结

```java
class Solution {
    public void reverseString(char[] s) {
        // 思路
        // 双指针 => 两两调换。O(n) + O(1)
        if (s == null || s.length == 0) {
            return;
        }
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - i - 1);
        }
    }

    private void swap(char[] s, int first, int second) {
        char temp = s[first];
        s[first] = s[second];
        s[second] = temp;
    }
}
```

| 问题行数 | 错误点                  | 正确写法             | 错误原因 |
|------|----------------------|------------------|------|
| 16   | s[second] = s[first] | s[second] = temp | 粗心大意 |
