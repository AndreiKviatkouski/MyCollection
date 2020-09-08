package com.company.queue;

public interface MyQueue<E> {
    boolean add(E e);
    boolean offer(E e);

    E remove();
    E poll();

    E element();
    E peek();
}
