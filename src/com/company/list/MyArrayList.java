package com.company.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    ArrayList<E> list = new ArrayList<>();
    private Object[] objects;
    private int size;
    

    public MyArrayList() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        this.objects = new Object[initialCapacity];
    }
List<String>list1t = new LinkedList<>();
    @Override
    public void add(E e) {
        if (size == objects.length) grow();
        objects[size++] = e;
    }

    private void grow(){
        int oldCapacity = objects.length;
        int newCapacity = oldCapacity + (oldCapacity / 2);
        if (newCapacity < 0) throw new OutOfMemoryError();
        this.objects = Arrays.copyOf(objects, newCapacity);
    }

    @Override
    public void add(E e, int index) {
        if (size == objects.length) grow();
        if (objects.length - 1 - index >= 0)
            System.arraycopy(objects, index, objects, index + 1, objects.length - 1 - index);
        objects[index] = e;
        size++;
    }

    @Override
    public E set(E e, int index) {
        Object old = objects[index];
        objects[index] = e;
        return (E) old;
    }

    @Override
    public E remove(int index) {
        Object old = objects[index];
        for (int i = index; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }
        size--;
        return (E) old;
    }

    @Override
    public E get(int index) {
        return (E) objects[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "list=" + list +
                ", objects=" + Arrays.toString(objects) +
                ", size=" + size +
                '}';
    }
}
