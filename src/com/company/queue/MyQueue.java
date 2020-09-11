package com.company.queue;

import java.util.NoSuchElementException;

public interface MyQueue<E> {
    boolean add(E e);
    boolean offer(E e);

    E remove();
    E poll();

    E element() throws NoSuchElementException;
    E peek();
}
