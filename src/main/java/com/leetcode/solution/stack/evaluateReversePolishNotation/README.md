## 逆波兰表达式求值

<https://leetcode.cn/problems/evaluate-reverse-polish-notation/>

### 思路

使用栈存储数字，如遇到二元操作符，取出两个数字依次为a和b，之后形成 a operate b 的形式，之后将结果入栈
循环往复，直至没有字符
数组前两个元素不可以是操作符

### 总结

| 问题行数 | 错误点        | 正确写法            | 错误原因               |
|------|------------|-----------------|--------------------|
| 36   | str == "+" | "+".equals(str) | String 判等使用 equals |

```java
class Solution {
    // 思路：使用栈模拟。遇到数字入栈，遇到 + - * / pop 两个值，进行运算，之后将结果压栈
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return Integer.MIN_VALUE;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if (isOperate(current) && !stack.isEmpty()) {
                int right = stack.pop();
                int left = stack.pop();
                switch (current) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    default:
                        stack.push(left / right);
                }
            } else {
                stack.push(Integer.parseInt(current));
            }
        }

        return stack.pop();
    }

    private boolean isOperate(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }
}
```


