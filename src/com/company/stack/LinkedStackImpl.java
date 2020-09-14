package com.company.stack;

import com.company.list.MyDeqLinkedList;
import com.company.list.MyLinkedList;

public class LinkedStackImpl<E> implements Stack<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    // TODO: 08.09.2020 Реализовать стек на нодах
    @Override
    public E push(E e) {
        Node<E> eNode;
        if (empty()) {
            eNode = new Node<>(e, null, null);
            this.first = eNode;
        } else {
            eNode = new Node<>(e, this.last, null);
            this.last.next = eNode;
        }
        this.last = eNode;
        size++;
        return e;
    }

    @Override
    public E pop() {
        if (empty()) {
            return null;
        }
        Node<E> temp = this.first;
        for (int i = 0; i < size + 1; i++) {
            if (i == size) {
                return temp.element;
            }
            temp = temp.next;
        }
        Object old = first;
        first = null;
        size--;
        return temp.element;
    }

    @Override
    public E peek() {
        Node<E> temp = this.first;
        for (int i = 0; i < size+1; i++) {
            if (i == size) {
                return temp.element;
            }
            temp = temp.next;
        }
        return null;
    }


    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(E e) {
      Node<E> temp = this.first;
        for (int i = size - 1, j = 0; i >= 0; i--) {
            if (temp.getElement()== null) continue;
            if (temp.getElement().equals(e)) {
                return j+1;
            } else {
                j++;
            }
            temp = temp.next;
        }
        return -1;
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, LinkedStackImpl.Node<E> prev, LinkedStackImpl.Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public LinkedStackImpl.Node<E> getPrev() {
            return prev;
        }

        public void setPrev(LinkedStackImpl.Node<E> prev) {
            this.prev = prev;
        }

        public LinkedStackImpl.Node<E> getNext() {
            return next;
        }

        public void setNext(LinkedStackImpl.Node<E> next) {
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

