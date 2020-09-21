package com.company.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Objects.hash;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;
    private List<Map.Entry<K, V>> entryList;
    private int size;

    public MyHashMap() {
        this.table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        this.entryList = new ArrayList<>();
    }

    private int tableNum(int hash) {
        return hash % (table.length - 1);
    }

    private Node<K, V> getNode(int hash, K key) {
        if (table[tableNum(hash)] == null) {
            return null;
        } else {
            Node<K, V> current = table[tableNum(hash)];

            while (current.next != null) {
                if (current.getKey().equals(key)) {
                    return current;
                }
                current = current.next;
            }
            return current;
        }
    }


    @Override
    public V put(K k, V v) {
        if (k == null) {
            throw new IllegalStateException();
        }

        return null;
    }

    @Override
    public V remove(K k) {
        Node<K, V> currentNode;
        if ((currentNode = getNode(hash(k), (K) k)) == null) {
            return null;
        } else {
            if (currentNode.key.equals(k)) {
                table[tableNum(currentNode.hash)] = null;
            } else {
                while (!currentNode.next.getKey().equals(k)) {
                    currentNode = currentNode.next;
                }
                currentNode.next = null;
            }
            size--;
            return currentNode.value;
        }
    }


    @Override
    public V get(K k) {
        Node<K, V> node = getNode(hash(k), (K) k);
        return node == null ? null : node.getValue();
    }


    @Override
    public List<K> keys() {
        int count = 0;
        return null;
    }

    @Override
    public List<V> values() {
        return null;
    }

    @Override
    public List<Map.Entry<K, V>> entries() {
        return null;
    }

    @Override
    public boolean containsKey(K k) {
        for (Map.Entry<K, V> item : entryList) {
            if (item.getKey() == k) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        for (Map.Entry<K, V> item : entryList) {
            if (item.getValue() == v) {
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
