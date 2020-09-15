package com.company.map;

import java.util.List;
import java.util.Map;

public interface MyMap<K, V> {
    V put(K k, V v);
    V remove(K k);
    V get(K k);

    List<K> keys();
    List<V> values();
    List<Map.Entry<K, V>> entries();

    boolean containsKey(K k);
    boolean containsValue(V v);
}
