package com.company.queue;

public interface MyDeque<E> {
    void addFirst(E e);
    void addLast(E e);
    boolean offerFirst(E e);
    boolean offerLast(E e);

    E removeFirst();
    E removeLast();
    E pollFirst();
    E pollLast();

    E getFirst();
    E getLast();
    E peekFirst();
    E peekLast();

    boolean isEmpty();
}
