package com.company.queue;

import java.util.NoSuchElementException;

public class MyQueueNode<E> implements MyQueue<E> {
    private Node<E> root;
    private int size;

    @Override
    public boolean add(E e) {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Node<E> temp = this.root;
        while (true) {
            if (temp.next == null) {
                temp.next = new Node<>(e);
                size++;
                break;
            }
            temp = temp.next;
        }
        return true;
    }

    @Override
    public boolean offer(E e) {
        if (size == 0) {
            return false;
        }
        Node<E> temp = this.root;
        while (true) {
            if (temp.next == null) {
                temp.next = new Node<>(e);
                size++;
                break;
            }
            temp = temp.next;
        }
        return true;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> temp = this.root;
        Node<E> right = temp.next;
        E old = temp.getElement();
        right.next = right;
        temp.next = null;
        temp.setElement(null);
        size--;
        return old;
    }


    @Override
    public E poll() {
        if (size == 0) {
            return  null;
        }
        Node<E> temp = this.root;
        Node<E> right = temp.next;
        E old = temp.getElement();
        right.next = right;
        temp.next = null;
        temp.setElement(null);
        size--;
        return old;
    }


    @Override
    public E element() throws NoSuchElementException {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Node<E> result = root;
        for (int i = 0; i < size; i++) {
            result = result.next;
        }

        return result.element;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        Node<E> result = root;
        for (int i = 0; i < size; i++) {
            result = result.next;
        }

        return result.element;
    }


    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }
}
