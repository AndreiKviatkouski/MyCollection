package com.company.queue;

public class MyQueueImpl<E> implements MyQueue<E> {
    private Object[] objects = new Object[10];
    private int size;

    @Override
    public boolean add(E e) {
        if (size == objects.length){
            throw new IllegalStateException();
        }
        objects[size++] = e;
        return true;
    }

    @Override
    public boolean offer(E e) {
        if (size == objects.length){
           return false;
        }
        objects[size++] = e;
        return true;
    }


    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
