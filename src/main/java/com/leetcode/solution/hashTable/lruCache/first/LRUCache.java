package com.leetcode.solution.hashTable.lruCache.first;

import com.leetcode.solution.hashTable.lruCache.LRUCacheTemplate;

import java.util.HashMap;
import java.util.Map;

public class LRUCache extends LRUCacheTemplate {

    private final int capacity;
    private final Map<Integer, DoubleLinkedList> map;
    private final DoubleLinkedList dummyHeadNode;
    private final DoubleLinkedList dummyTailNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHeadNode = new DoubleLinkedList(-1, -1);
        this.dummyTailNode = new DoubleLinkedList(-1, -1);
        dummyHeadNode.after = dummyTailNode;
        dummyTailNode.before = dummyHeadNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // move node to tail
            DoubleLinkedList node = map.get(key);
            moveNodeToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkedList newNode = new DoubleLinkedList(key, value);
        if (map.containsKey(key)) {
            // update + move current node to tail
            DoubleLinkedList currentNode = map.get(key);
            newNode.after = currentNode.after;
            newNode.before = currentNode.before;
            map.put(key, newNode);
            moveNodeToTail(newNode);
            return;
        }
        // add
        removeEldestEntry();

        // update tail
        dummyTailNode.before.after = newNode;
        newNode.before = dummyTailNode.before;
        newNode.after = dummyTailNode;
        dummyTailNode.before = newNode;
        map.put(key, newNode);
    }

    private void moveNodeToTail(DoubleLinkedList node) {
        node.before.after = node.after;
        node.after.before = node.before;

        node.before = dummyTailNode.before;
        dummyTailNode.before.after = node;
        node.after = dummyTailNode;
        dummyTailNode.before = node;
    }

    private void removeEldestEntry() {
        // remove eldest node
        if (map.size() >= capacity) {
            map.remove(dummyHeadNode.after.key);
            dummyHeadNode.after.after.before = dummyHeadNode;
            dummyHeadNode.after = dummyHeadNode.after.after;
        }
    }

    static class DoubleLinkedList {
        DoubleLinkedList before;
        DoubleLinkedList after;
        int key;
        int value;

        public DoubleLinkedList(int key, int value) {
            this(null, null, key, value);
        }

        public DoubleLinkedList(DoubleLinkedList before, DoubleLinkedList after, int key, int value) {
            this.before = before;
            this.after = after;
            this.key = key;
            this.value = value;
        }
    }
}
