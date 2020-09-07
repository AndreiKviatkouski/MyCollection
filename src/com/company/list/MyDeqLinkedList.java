package com.company.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyDeqLinkedList<E> implements MyList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    LinkedList<String>linkedList = new LinkedList<>();
    public static void main(String[] args) {
        MyDeqLinkedList<String> stringMyDeqLinkedList = new MyDeqLinkedList<>();
        stringMyDeqLinkedList.add("Hello 1");
        stringMyDeqLinkedList.add("Hello 2");
        stringMyDeqLinkedList.add("Hello 3");
        stringMyDeqLinkedList.add("Hello 4");
        System.out.println(stringMyDeqLinkedList);
//        stringMyDeqLinkedList.add("Hello 33", 2);
//        System.out.println(stringMyDeqLinkedList);
        System.out.println(stringMyDeqLinkedList.remove(2));
        System.out.println(stringMyDeqLinkedList);

    }

    @Override
    public void add(E e) {
        if (isEmpty()) {
            Node<E> eNode = new Node<>(e, null, null);
            this.first = eNode;
            this.last = eNode;
            size++;
        } else {
            Node<E> eNode = new Node<>(e, this.last, null);//1
            this.last.next = eNode;//2
            this.last = eNode;//3
            size++;
        }
    }

    @Override
    public void add(E e, int index) {
        Node<E> temp = this.first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Node<E> right = temp;
                Node<E> left = temp.prev;
                Node<E> eNode1 = new Node<>(e, left, right);
                right.prev = eNode1;
                left.next = eNode1;
                break;
            }
            temp = temp.next;
        }
        size++;
    }

    @Override
    public E set(E e, int index) {
        E old = null;
        Node<E> temp = this.first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                old = temp.getElement();
                temp.setElement(e);
            }
            temp = temp.next;
        }
        return old;
    }

    @Override
    public E remove(int index) {
        Node<E> temp = this.first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Node<E> left = temp.prev;
                Node<E> right = temp.next;
                E old = temp.getElement();
                left.next = right;
                right.prev = left;
                temp.next = null;
                temp.prev = null;
                temp.setElement(null);
                size--;
                return old;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public E get(int index) {
        Node<E> temp = this.first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return temp.element;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> temp = this.first;
        for (int i = 0; i < size; i++) {
            if (temp.getElement().equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (LinkedList.Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyDeqLinkedList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
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

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
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
//                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
}
