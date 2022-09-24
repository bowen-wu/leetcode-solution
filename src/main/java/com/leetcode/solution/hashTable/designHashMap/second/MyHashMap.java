package com.leetcode.solution.hashTable.designHashMap.second;

class MyHashMap {
    // Ideas: 数组 + 链表实现哈希表
    static class Node {
        int val;
        int key;
        Node next;

        public Node(int val, int key, Node next) {
            this.val = val;
            this.key = key;
            this.next = next;
        }

        public Node(int val, int key) {
            this(val, key, null);
        }
    }

    public static int DEFAULT_CAPACITY = 16;
    public static float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node[] table;
    private int capacity;
    private float loadFactor;
    private int size;

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Node[capacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public void put(int key, int value) {
        if (size > capacity * loadFactor) {
            resize();
        }
        int hashcode = hash(key);
        Node node = table[hashcode];

        if (node == null) {
            table[hashcode] = new Node(value, key);
            size++;
            return;
        }

        // single node
        if (node.key == key) {
            // update
            node.val = value;
            return;
        }

        Node next = node.next;
        while (node != null) {
            if (node.key == key) {
                // update
                node.val = value;
                return;
            }
            if (next == null) {
                // node 是最后一个元素了
                node.next = new Node(value, key);
                size++;
                return;
            }

            node = node.next;
            next = next.next;
        }
    }

    public int get(int key) {
        int hashcode = hash(key);
        Node node = table[hashcode];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashcode = hash(key);
        Node node = table[hashcode];
        Node dummyNode = new Node(-1, -1, node);
        Node prev = dummyNode;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                table[hashcode] = dummyNode.next;
                return;
            }
            node = node.next;
            prev = prev.next;
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
                if (newTable[newHashcode] != null) {
                    Node newNode = newTable[newHashcode];
                    while (newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.val, node.key);
                } else {
                    newTable[newHashcode] = new Node(node.val, node.key);
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
