package com.leetcode.solution.hashTable.lruCache.second;

import com.leetcode.solution.hashTable.lruCache.LRUCacheTemplate;

import java.util.HashMap;
import java.util.Map;

public class LRUCache extends LRUCacheTemplate {
    // Ideas: map + doubleLinkedList
    static class DoubleLinkedList {
        DoubleLinkedList before;
        DoubleLinkedList after;
        int key;
        int value;

        public DoubleLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DoubleLinkedList> map;
    DoubleLinkedList dummyHeadNode;
    DoubleLinkedList dummyTailNode;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummyHeadNode = new DoubleLinkedList(-1, -1);
        this.dummyTailNode = new DoubleLinkedList(-1, -1);
        dummyHeadNode.after = dummyTailNode;
        dummyTailNode.before = dummyHeadNode;
    }

    public int get(int key) {
        // update position
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            moveNodeToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // update
            DoubleLinkedList node = map.get(key);
            node.value = value;
            moveNodeToTail(node);
            map.put(key, node);
            return;
        }

        // add
        if (map.size() >= capacity) {
            DoubleLinkedList removeNode = dummyHeadNode.after;
            DoubleLinkedList next = removeNode.after;
            dummyHeadNode.after = next;
            next.before = dummyHeadNode;
            map.remove(removeNode.key);
        }
        DoubleLinkedList node = new DoubleLinkedList(key, value);
        addNodeToTail(node);
        map.put(key, node);
    }

    private void moveNodeToTail(DoubleLinkedList node) {
        node.before.after = node.after;
        node.after.before = node.before;
        addNodeToTail(node);
    }

    private void addNodeToTail(DoubleLinkedList node) {
        node.before = dummyTailNode.before;
        node.after = dummyTailNode;
        dummyTailNode.before.after = node;
        dummyTailNode.before = node;
    }
}
