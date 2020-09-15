package com.company.map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyMapImpl<K, V> implements MyMap<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];
    private int size;

    public static void main(String[] args) {
        MyMapImpl<String, String> stringStringMyMap = new MyMapImpl<>();
        stringStringMyMap.put("1", "11");
        stringStringMyMap.put("2", "22");
        stringStringMyMap.put("3", "33");
        stringStringMyMap.put("4", "44");
        stringStringMyMap.put("5", "55");

        System.out.println(stringStringMyMap);

//        System.out.println(stringStringMyMap.get("3"));

//        System.out.println(stringStringMyMap.remove("4"));

//        System.out.println(stringStringMyMap);

//        System.out.println(stringStringMyMap.containsKey("3"));
//        System.out.println(stringStringMyMap.containsKey("9"));
//        System.out.println(stringStringMyMap.containsValue("33"));
//        System.out.println(stringStringMyMap.containsValue("99"));

        System.out.println(stringStringMyMap.put("2", "222"));

        System.out.println(stringStringMyMap);
    }

    @Override
    public V put(K k, V v) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)){
                Object old = values[i];
                values[i] = v;
                return (V) old;
            }
        }
        keys[size] = k;
        values[size] = v;
        size++;
        return v;
    }

    @Override
    public V remove(K k) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)){
                Object old = values[i];
                for (int i1 = i; i1 < keys.length - 1; i1++) {
                    keys[i1] = keys[i1 + 1];
                }
                for (int i1 = i; i1 < values.length - 1; i1++) {
                    values[i1] = values[i1 + 1];
                }
                size--;
                return (V)old;
            }

        }
        return null;
    }

    @Override
    public V get(K k) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)){
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public List<K> keys() {
        int count =0;
        for (int i = 0; i < size; i++) {
            if (keys[i]==null){
                count++;
            }
        }
        K[] a = (K[]) Arrays.copyOf(keys, count);
        return Arrays.asList(a);
    }

    @Override
    public List<V> values() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (values[i]==null){
                count++;
            }
        }
       V[] b = (V[])Arrays.copyOf(values, count);
        return Arrays.asList(b);
    }

    @Override
    public List<Map.Entry<K, V>> entries() {
        Entry<Object, Object> objectObjectEntry = new Entry<>(keys[0], values[0]);
        List<Map.Entry<K, V>> list = new LinkedList<>();
        list.add((Map.Entry<K, V>) objectObjectEntry);
        return null;
    }

    @Override
    public boolean containsKey(K k) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(v)){
                return true;
            }
        }
        return false;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyMapImpl{" +
                "keys=" + Arrays.toString(keys) +
                ", values=" + Arrays.toString(values) +
                ", size=" + size +
                '}';
    }
}
