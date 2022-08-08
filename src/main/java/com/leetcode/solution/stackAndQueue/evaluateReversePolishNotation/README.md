## 逆波兰表达式求值

<https://leetcode.cn/problems/evaluate-reverse-polish-notation/>

### 思路

使用栈存储数字，如遇到二元操作符，取出两个数字依次为a和b，之后形成 a operate b 的形式，之后将结果入栈
循环往复，直至没有字符
数组前两个元素不可以是操作符


