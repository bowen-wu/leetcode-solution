package com.leetcode.solution.breadthFirstSearch.wordLadder.first;

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
        if (beginWord == null && endWord == null) {
            return 1;
        }

        // check input
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }

        // corn case
        if (beginWord.equals(endWord)) {
            return 1;
        }

        // Duplicated word
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        // queue
        Queue<String> queue = new LinkedList<>();

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
                if (endWord.equals(word)) {
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
        // check input
        if (beginWord == null && endWord == null) {
            return 1;
        }

        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> set = new HashSet<>(wordList);

        // core case
        if (!set.contains(endWord)) {
            return 0;
        }
        Set<String> beginToEndSet = new HashSet<>();
        Set<String> endToBeginSet = new HashSet<>();

        // queue
        Queue<String> beginToEndQueue = new LinkedList<>();
        Queue<String> endToBeginQueue = new LinkedList<>();

        // offer & mark
        beginToEndQueue.offer(beginWord);
        beginToEndSet.add(beginWord);
        endToBeginQueue.offer(endWord);
        endToBeginSet.add(endWord);
        int level = 0;

        // traversal
        while (!beginToEndQueue.isEmpty() && !endToBeginQueue.isEmpty()) {
            level++;
            if (beginToEndQueue.size() > endToBeginQueue.size()) {
                if (update(endToBeginQueue, endToBeginSet, beginToEndSet, set)) {
                    return level + 1;
                }
            } else {
                if (update(beginToEndQueue, beginToEndSet, endToBeginSet, set)) {
                    return level + 1;
                }
            }
        }

        return 0;
    }

    private boolean update(Queue<String> updateQueue, Set<String> visited, Set<String> anotherVisited, Set<String> set) {
        int size = updateQueue.size();
        for (int i = 0; i < size; i++) {
            String word = updateQueue.poll();
            for (String adjacencyWord : getAdjacencyWordList(word, set)) {
                if (anotherVisited.contains(adjacencyWord)) {
                    return true;
                }

                if (!visited.contains(adjacencyWord)) {
                    // offer & mark
                    updateQueue.offer(adjacencyWord);
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
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) {
                    continue;
                }
                char[] chars = word.toCharArray();
                chars[i] = c;
                String newWord = new String(chars);
                if (set.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }
}
