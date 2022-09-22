package com.algorithmsAndDataStructures.hashTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Traversal {
    public Map<String, String> map = new HashMap<>();

    public void traversalForLambda() {
        // 推荐
        map.forEach((key, value) -> System.out.println("The key: " + key + ", the value: " + value));
    }

    public void traversalForEach() {
        // 推荐
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println("The key: " + entry.getKey() + ", the value: " + entry.getValue());
        }
    }

    public void traversalForKeySet() {
        for (String key : map.keySet()) {
            System.out.println("The key: " + key + ", the value: " + map.get(key));
        }
    }

    public void traversalForIterator() {
        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            System.out.println("The key: " + entry.getKey() + ", the value: " + entry.getValue());
        }
    }
}
