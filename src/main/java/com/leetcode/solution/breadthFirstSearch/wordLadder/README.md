## 单词接龙

<https://leetcode.cn/problems/word-ladder/>

### 思路

1. 构建图 => beginWord 每一个字母分别替换从 a - z，每个字母都有25中可能，如果改可能在字典中，则加入邻接表中

### 总结

1. endWord 需要在 wordList 中
2. 注意 level 初始值

| 问题行数 | 错误点 | 正确写法 | 错误原因 |
|------|-----|------|------|
|      |     |      |      |

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Ideas: 单向 BFS
        // check input
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!set.contains(endWord)) {
            return 0;
        }

        // queue
        Queue<String> queue = new LinkedList<>();

        // offer & mark
        queue.offer(beginWord);
        visited.add(beginWord);
        int size;
        int level = 0;

        while (!queue.isEmpty()) {
            size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }

                for (String adjacencyWord : getAdjacencyWord(word, set)) {
                    if (!visited.contains(adjacencyWord)) {
                        // offer & mark
                        queue.offer(adjacencyWord);
                        visited.add(adjacencyWord);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getAdjacencyWord(String word, Set<String> set) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            for (int j = 0; j < 26; j++) {
                char replaceChar = (char) (j + 'a');
                if (replaceChar == currentChar) {
                    continue;
                }
                char[] chars = word.toCharArray();
                chars[i] = replaceChar;
                String newWord = new String(chars);
                if (set.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

    public int ladderLengthBilateralBFS(String beginWord, String endWord, List<String> wordList) {
        // Ideas: 双向 BFS
        // check input
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        // queue
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        // offer & mark
        queue1.offer(beginWord);
        visited1.add(beginWord);
        queue2.offer(endWord);
        visited2.add(endWord);
        int level = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            level++;
            if (queue1.size() > queue2.size()) {
                if (update(queue2, visited2, visited1, set)) {
                    return level;
                }
            } else {
                if (update(queue1, visited1, visited2, set)) {
                    return level;
                }
            }

        }
        return 0;
    }

    private boolean update(Queue<String> updateQueue, Set<String> visited, Set<String> check, Set<String> set) {
        int size = updateQueue.size();
        for (int i = 0; i < size; i++) {
            String word = updateQueue.poll();
            if (check.contains(word)) {
                return true;
            }

            for (String adjacencyWord : getAdjacencyWord(word, set)) {
                if (!visited.contains(adjacencyWord)) {
                    // offer & mark
                    updateQueue.offer(adjacencyWord);
                    visited.add(adjacencyWord);
                }
            }
        }
        return false;
    }
}
```
