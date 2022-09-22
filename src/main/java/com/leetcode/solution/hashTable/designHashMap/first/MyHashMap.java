package com.leetcode.solution.hashTable.designHashMap.first;

import com.leetcode.solution.hashTable.designHashMap.MyHashMapTemplate;

public class MyHashMap extends MyHashMapTemplate {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(2, 2);
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int initCapacity;
    private final float loadFactor;
    private Node[] table;
    private int size;

    public MyHashMap(int initCapacity, float loadFactor) {
        this.initCapacity = initCapacity;
        this.loadFactor = loadFactor;
        this.table = new Node[initCapacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    @Override
    public void put(int key, int value) {
        if (size > initCapacity * loadFactor) {
            resize();
        }
        int hashcode = hash(key);
        Node node = table[hashcode];
        if (node == null) {
            table[hashcode] = new Node(key, value, null);
            size++;
            return;
        }

        Node prev = new Node(-1, -1, node);
        while (node != null) {
            if (node.key == key) {
                // update
                node.value = value;
                return;
            }

            node = node.next;
            prev = prev.next;
        }

        size++;
        prev.next = new Node(key, value, null);
    }

    @Override
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

    @Override
    public void remove(int key) {
        int hashcode = hash(key);
        Node node = table[hashcode];

        Node dummyNode = new Node(-1, -1, node);
        Node prev = dummyNode;

        while (node != null) {
            if (node.key == key) {
                Node next = node.next;
                node.next = null;
                prev.next = next;
                table[hashcode] = dummyNode.next;
                return;
            }

            node = node.next;
            prev = prev.next;
        }
    }

    private int hash(int key) {
        return key % initCapacity;
    }

    private void resize() {
        int newCapacity = initCapacity * 2;
        this.initCapacity = newCapacity;
        Node[] newTable = new Node[newCapacity];
        for (Node node : table) {
            while (node != null) {
                int key = node.key;
                int newHashcode = hash(key);

                if (newTable[newHashcode] != null) {
                    Node currentNode = newTable[newHashcode];
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = new Node(node.key, node.value, null);
                } else {
                    newTable[newHashcode] = new Node(node.key, node.value, null);
                }

                node = node.next;
            }
        }
        this.table = newTable;
    }
}
