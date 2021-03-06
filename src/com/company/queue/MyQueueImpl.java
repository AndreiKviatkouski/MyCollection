package com.company.queue;

import java.util.NoSuchElementException;

public class MyQueueImpl<E> implements MyQueue<E> {
    private Object[] objects = new Object[10];
    private int size ;

    @Override
    public boolean add(E e) {
        if (size == objects.length) {
            throw new IllegalStateException();
        }
        objects[size++] = e;
        return true;
    }

    @Override
    public boolean offer(E e) {
        if (size == objects.length) {
            return false;
        }
        objects[size++] = e;
        return true;
    }


    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Object old = objects[0];
        for (int i = 0; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }
        size--;
        return (E) old;

    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;

        }
        Object old = objects[0];
        for (int i = 0; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }
        size--;
        return (E) old;
    }

    @Override
    public E element()  {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (E) objects[0];
    }


    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) objects[0];
    }
}
