## 复原 IP 地址

<https://leetcode.cn/problems/restore-ip-addresses/>

### 思路

回溯法 => 排序问题 => 获取所有元素

1. 是否需要排序 => 不需要
2. 是否需要元素位置索引 => 不需要
3. helper 函数定义 => ` void helper(List<List<Integer>> result, List<Integer> list, String s) `
4. 单一解 => list.add(s.subString(len))
5. 递归何时退出 => s.length == 0
6. 单一解何时加入解集 => s.length == 0 && list.size() == 4
7. 剪枝 => s 逐步递减
    1. len > s.length
    2. len > 1 && s.subString(0, len).startWith("0")
    3. Integer.parseInt(s.subString(0, len)) > 255
    4. 至多 => s.length() > 3 * (4 - list.size())
    5. 至少 => s.length() < 1 * (4 - list.size())
8. 如何分解子问题到下一层 => for (int len = 1; len < 4; i++)
9. 如何回溯 => 删除单一解的最后一个元素

#### 优化

1. 单一解加入解集时 join

### 总结

TODO: 能否使用记忆化搜索

| 问题行数 | 错误点                                                                                                                                | 正确写法                                                                                                                                       | 错误原因                       |
|------|------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|----------------------------|
| 38   | -                                                                                                                                  | 新增 isValidIpPart 函数                                                                                                                        | 没有考虑 ipPart < 255          |
| 38   | if (isValidIpPart(substring)                                                                                                       | if (!isValidIpPart(substring)                                                                                                              | 大意                         |
| 50   | if (ipPart.chatAt(0) == '0' && ipPart.length > 1)                                                                                  | if (ipPart.charAt(0) == '0' && ipPart.length() > 1)                                                                                        | 没有考虑 ipPart < 255          |
| 17   | s.length                                                                                                                           | s.length()                                                                                                                                 | length 是字符串方法。大意           |
| 37   | if (!isValidIpPart(substring) &#124;&#124; (1 * (4 - list.size()) > s.length()) &#124;&#124; (s.length() > 3 * (4 - list.size()))) | if (!isValidIpPart(substring) &#124;&#124; (1 * (4 - list.size()) > s.length() - i) &#124;&#124; (s.length() - i > 3 * (4 - list.size()))) | 剪枝 length 时需要把已经用掉的减去。剪枝思路 |

1. 单一解加入解集 => ` list.size() == 4 `

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        // Ideas: backtracking => 排列问题
        // 1. 是否需要排序 => 不需要
        // 2. 是否需要元素位置索引 => 需要
        // 3. helper 函数定义 => void helper(List<String> result, List<String> list, String s, int position) 
        // 4. 递归何时退出 => position >= s.length
        // 5. 单一解何时加入解集 => position >= s.length
        // 6. 剪枝
        // 		1. ip range => 1 * 4 <= ip <= 3 * 4 => 1 * (4 - list.size()) <= s.length() - position <= 3 * (4 - list.size())
        // 7. 如何递归分解子问题到下一层 => for loop
        // 8. 如何回溯 => 单一解删除最后一个元素
        // 解集
        List<String> result = new ArrayList<>();

        // check input
        if (s == null || 1 * 4 > s.length() || s.length() > 3 * 4) {
            return result;
        }

        // 单一解 + 计算解集 => 单一解加入解集中
        List<String> list = new ArrayList<>();
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int position) {
        // 递归何时退出
        if (position >= s.length()) {
            result.add(String.join(".", list));
            return;
        }

        // 递归分解子问题到下一层 + 剪枝
        for (int i = position; i < s.length() && i - position < 3; i++) {
            String substring = s.substring(position, i + 1);
            if (!isValidIpPart(substring) || (1 * (4 - list.size()) > s.length() - i) || (s.length() - i > 3 * (4 - list.size()))) {
                // 剪枝
                break;
            }

            list.add(substring);
            helper(result, list, s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValidIpPart(String ipPart) {
        if (ipPart.charAt(0) == '0' && ipPart.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(ipPart);
        return num >= 0 && num <= 255;
    }
}
```
