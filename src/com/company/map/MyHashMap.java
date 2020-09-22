package com.company.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;
    private List<Map.Entry<K, V>> entryList;
    private int size;

    public MyHashMap() {
        this.table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        this.entryList = new ArrayList<>();
    }

    public static void main(String[] args) {
        MyHashMap<String, String> stringStringMyHashMap = new MyHashMap<>();
        stringStringMyHashMap.put("1", "Hello 1");
        stringStringMyHashMap.put("2", "Hello 2");
        stringStringMyHashMap.put("3", "Hello 3");
        System.out.println(stringStringMyHashMap.keys());

        System.out.println(stringStringMyHashMap.values());

        System.out.println(stringStringMyHashMap);

//        System.out.println(stringStringMyHashMap.get("3"));

        System.out.println(stringStringMyHashMap.remove("2"));

        System.out.println(stringStringMyHashMap);
    }

    private int getIndex(K k) {
        return Math.abs(k.hashCode() % DEFAULT_CAPACITY);
    }

    @Override
    public V put(K k, V v) {
        Node<K, V> kvNode = new Node<>(k.hashCode(), k, v, null);
        int index = getIndex(k);

        if (table[index] == null) {
            table[index] = kvNode;
            size++;
            entryList.add(kvNode);
        } else {
            Node<K, V> temp = table[index];
            while (temp != null) {
                if (temp.key.equals(k)) {
                    V old = temp.getValue();
                    temp.setValue(v);
                    return old;
                }
                temp = temp.next;
            }
            Node<K, V> kvNode1 = table[index];
            kvNode.next = kvNode1;
            table[index] = kvNode;
            size++;
            entryList.add(kvNode);
        }
        return v;
    }

    @Override
    public V remove(K k) {
        int index = getIndex(k);
        if (table[index] != null) {
            if (table[index].getKey().equals(k)) {
                Node<K, V> kvNode = table[index];
                Node<K, V> right = kvNode.next;
                table[index] = right;
                entryList.remove(kvNode);
                V old = kvNode.getValue();
                kvNode.next = null;
                kvNode.key = null;
                size--;
                return old;
            } else {
                Node<K, V> temp = table[index];
                while (temp.next != null) {
                    if (temp.next.getKey().equals(k)) {
                        Node<K, V> left = temp;
                        Node<K, V> right = temp.next.next;
                        temp.next.next = null;
                        temp.key = null;
                        entryList.remove(temp);
                        V old = temp.value;
                        temp.value = null;
                        left.next = right;
                        size--;
                        return old;
                    }
                }
            }
        }
        return null;
    }


    @Override
    public V get(K k) {
        int index = getIndex(k);
        Node<K, V> temp = table[index];
        while (temp != null) {
            if (temp.getKey().equals(k)) {
                return temp.getValue();
            }
            temp = temp.next;
        }
        return null;
    }


    @Override
    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Map.Entry<K, V> kvEntry : entryList) {
            keys.add(kvEntry.getKey());
        }
        return keys;
    }

    @Override
    public List<V> values() {
        List<V> value = new ArrayList<>();
        for (Map.Entry<K, V> kvEntry : entryList) {
            value.add(kvEntry.getValue());
        }
        return value;
    }

    @Override
    public List<Map.Entry<K, V>> entries() {
        return new ArrayList<>(entryList);
    }

    @Override
    public boolean containsKey(K k) {
        for (Map.Entry<K, V> kvEntry : entryList) {
            if (kvEntry.getKey().equals(k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        for (Map.Entry<K, V> kvEntry : entryList) {
            if (kvEntry.getValue().equals(v)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "table=" + Arrays.toString(table) +
                ", entryList=" + entryList +
                ", size=" + size +
                '}';
    }

    private static class Node<K, V> implements Map.Entry<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public Node<K, V> getNext() {
            return next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V value1 = this.value;
            this.value = value;
            return value1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
