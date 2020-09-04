package com.company.list;

public interface MyList<E> {
    void add(E e);
    void add(E e, int index);
    E set(E e, int index);
    E remove(int index);
    E get(int index);
    boolean contains(Object o);
    boolean isEmpty();
    Object[] toArray();
    int size();
}
