## 单词接龙

<https://leetcode.cn/problems/word-ladder/>

### 思路

1. 构建图 => beginWord 每一个字母分别替换从 a - z，每个字母都有25中可能，如果改可能在字典中，则加入邻接表中
