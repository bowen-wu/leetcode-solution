package com.leetcode.solution.breadthFirstSearch.wordLadder.third;

import com.leetcode.solution.breadthFirstSearch.wordLadder.LadderLengthTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LadderLength extends LadderLengthTemplate {

    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Ideas: BFS
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // offer & marked
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
                for (String adjacencyWord : getAdjacencyWordList(word, set)) {
                    if (!visited.contains(adjacencyWord)) {
                        // offer & marked
                        queue.offer(adjacencyWord);
                        visited.add(adjacencyWord);
                    }
                }
            }
        }

        return 0;
    }

    @Override
    public int ladderLengthBilateralBFS(String beginWord, String endWord, List<String> wordList) {
        // Ideas: 双向 BFS
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Queue<String> q2 = new LinkedList<>();
        Set<String> visited2 = new HashSet<>();

        // offer & marked
        q1.offer(beginWord);
        visited1.add(beginWord);
        q2.offer(endWord);
        visited2.add(endWord);
        int level = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            level++;
            if (q1.size() > q2.size()) {
                // q2
                if (traversalQueue(q2, visited2, visited1, set)) {
                    return level;
                }
            } else {
                // q1
                if (traversalQueue(q1, visited1, visited2, set)) {
                    return level;
                }
            }
        }

        return 0;
    }

    private boolean traversalQueue(Queue<String> queue, Set<String> visited, Set<String> check, Set<String> set) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            if (check.contains(word)) {
                return true;
            }

            for (String adjacencyWord : getAdjacencyWordList(word, set)) {
                if (!visited.contains(adjacencyWord)) {
                    // offer & marked
                    queue.offer(adjacencyWord);
                    visited.add(adjacencyWord);
                }
            }
        }
        return false;
    }

    private List<String> getAdjacencyWordList(String word, Set<String> set) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == ch) {
                    continue;
                }

                char[] chars = word.toCharArray();
                chars[i] = j;
                String newWord = new String(chars);
                if (set.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;
    }

}
