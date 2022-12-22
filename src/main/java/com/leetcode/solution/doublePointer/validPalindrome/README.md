## 验证回文串

<https://leetcode.cn/problems/valid-palindrome/>

### 思路

### 总结

| 问题行数 | 错误点                           | 正确写法                            | 错误原因           |
|------|-------------------------------|---------------------------------|----------------|
| 32   | ch1 = (char) ch1 + 'a' - 'A'; | ch1 = (char) (ch1 + 'a' - 'A'); | 强制类型转换         |
| 9    | int end = s.length();         | int end = s.length() - 1;       | end 初始值错误。边界问题 |
| 31   | if (ch1 >= 'A' && ch1 >= 'Z') | if (ch1 >= 'A' && ch1 <= 'Z')   | 大意             |
| 9    | int end = s.length();         | int end = s.length() - 1;       | end 初始值错误。边界问题 |

```java
class Solution {
    public boolean isPalindrome(String s) {
        // 字母和数字都属于字母数字字符
        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isBetterAndNumber(s.charAt(start))) {
                start++;
            } else if (!isBetterAndNumber(s.charAt(end))) {
                end--;
            } else {
                if (!equal(s.charAt(start), s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isBetterAndNumber(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private boolean equal(char ch1, char ch2) {
        if (ch1 >= 'A' && ch1 <= 'Z') {
            ch1 = (char) (ch1 + 'a' - 'A');
        }
        if (ch2 >= 'A' && ch2 <= 'Z') {
            ch2 = (char) (ch2 + 'a' - 'A');
        }
        return ch1 == ch2;
    }
}
```
