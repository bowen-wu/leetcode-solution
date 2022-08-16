## 有效的括号

<https://leetcode.cn/problems/valid-parentheses/>

### 思路

使用栈存储数据，如果栈顶和下一个元素是匹配的，则 pop，最终查看栈是否是空的

#### 优化

1. 长度为奇数 => 必然不匹配
2. stack 内只 push 左括号，如果遇到右括号并且 stack is empty，那么就不匹配 => case: ` ()())) `
3. 如果当前右括号和栈顶左括号不匹配，直接返回 false
    ```
    // No recommand
    if (isMatch(stack.peek(), currentChar)) {
        stack.pop();
    }
   
    // Recommand
    if (!isMatch(stack.pop(), currentChar)) {
        return false;
    }
    ```

### 总结

```java
class Solution {
    // 思路：使用栈进行模拟，遇到左括号入栈，遇到右括号和栈顶左括号匹配
    // 栈空，此时来了右括号，false
    // 循环结束，栈不空 false
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), current)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        return (left == '{' && right == '}') || (left == '[' && right == ']') || (left == '(' && right == ')');
    }
}
```

| 问题行数 | 错误点      | 正确写法       | 错误原因                      |
|------|----------|------------|---------------------------|
| 6    | Charger  | Character  | 不会写 Character Character   |
| 7    | s.length | s.length() | String API，length 是方法不是属性 |

