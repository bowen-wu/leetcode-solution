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
