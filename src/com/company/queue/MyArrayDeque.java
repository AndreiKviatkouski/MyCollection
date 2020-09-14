package com.company.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayDeque<E> implements MyDeque<E> {
    private Object[] objects = new Object[10];
    private int size;
    private int head;
    private int tail;

    public static void main(String[] args) {
        MyArrayDeque<String> stringMyArrayDeque = new MyArrayDeque<>();
        stringMyArrayDeque.addFirst("1");
        stringMyArrayDeque.addFirst("2");
        stringMyArrayDeque.addFirst("3");
        stringMyArrayDeque.addFirst("4");

        stringMyArrayDeque.addLast("5");
        stringMyArrayDeque.addLast("6");
        stringMyArrayDeque.addLast("7");
        stringMyArrayDeque.addLast("8");

        System.out.println(stringMyArrayDeque);

        System.out.println(stringMyArrayDeque.pollFirst());
        System.out.println(stringMyArrayDeque.pollFirst());
        System.out.println(stringMyArrayDeque.pollLast());
        System.out.println(stringMyArrayDeque.pollLast());

        System.out.println(stringMyArrayDeque);

        stringMyArrayDeque.addFirst("0");
        stringMyArrayDeque.addLast("0");

        System.out.println(stringMyArrayDeque);
    }

    @Override
    public void addFirst(E e) {
        if (objects.length == size) {
            throw new IllegalStateException();
        }
        size++;
        tail++;
        objects[head] = e;
    }

    // TODO: 12.09.2020 Дорабоать все методы MyArrayDeque
    // TODO: 12.09.2020 Реализовать одстр. очередь на Node
    // TODO: 12.09.2020 Исправить Node in LinkedStackImpl
    @Override
    public void addLast(E e) {
        if (objects.length == size) {
            throw new IllegalStateException();
        }
        size++;
        head++;
        objects[tail++] = e;
    }

    @Override
    public boolean offerFirst(E e) {
        if (objects.length == size) {
            return false;
        }
        size++;
        objects[head++] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (objects.length == size) {
            return false;
        }
        size++;
        objects[tail++] = e;
        return true;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object object = objects[head];
        objects[head--] = null;
        size--;
        return (E) object;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object old = objects[tail];
        objects[tail--] = null;
        size--;
        return (E) old;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Object object = objects[head];
        objects[head++] = null;
        size--;
        return (E) object;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Object object = objects[tail - 1];
        objects[--tail] = null;
        size--;
        return (E) object;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) objects[head];
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) objects[tail];
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return (E) objects[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return (E) objects[tail];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "MyArrayDeque{" +
                "objects=" + Arrays.toString(objects) +
                ", size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
