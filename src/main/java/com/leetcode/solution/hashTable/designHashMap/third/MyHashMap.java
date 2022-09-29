package com.leetcode.solution.hashTable.designHashMap.third;

import com.leetcode.solution.hashTable.designHashMap.MyHashMapTemplate;

public class MyHashMap extends MyHashMapTemplate {
    // Ideas: array + LinkedList
    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this(key, value, null);
        }

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static int DEFAULT_CAPACITY = 16;
    public static float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private Node[] table;
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[capacity];
    }

    public void put(int key, int value) {
        if (size > capacity * loadFactor) {
            resize();
        }
        int hashcode = hash(key);
        Node dummyNode = new Node(-1, -1, table[hashcode]);
        Node node = dummyNode;
        while (node.next != null) {
            if (node.next.key == key) {
                // update
                node.next.value = value;
                return;
            }
            node = node.next;
        }
        node.next = new Node(key, value);
        size++;
        table[hashcode] = dummyNode.next;
    }

    public int get(int key) {
        int hashcode = hash(key);
        Node node = table[hashcode];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashcode = hash(key);
        Node dummyNode = new Node(-1, -1);
        dummyNode.next = table[hashcode];
        Node node = dummyNode;
        while (node.next != null) {
            if (node.next.key == key) {
                Node next = node.next.next;
                node.next = next;
                table[hashcode] = dummyNode.next;
                size--;
                return;
            }
            node = node.next;
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        this.capacity = newCapacity;
        Node[] newTable = new Node[newCapacity];
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            while (node != null) {
                int newHashcode = hash(node.key);
                Node newNode = new Node(node.key, node.value);
                Node currentNode = newTable[newHashcode];
                if (currentNode == null) {
                    newTable[newHashcode] = newNode;
                } else {
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = newNode;
                }
                node = node.next;
            }
        }
        this.table = newTable;
    }

    private int hash(int key) {
        return key % capacity;
    }
}
