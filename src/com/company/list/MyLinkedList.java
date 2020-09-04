package com.company.list;

public class MyLinkedList<E> implements MyList<E>{
    private Node<E> root;
    private int size;

    public static void main(String[] args) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.add("Hello 1");
        stringMyLinkedList.add("Hello 2");
        stringMyLinkedList.add("Hello 3");
        stringMyLinkedList.add("Hello 4");
        stringMyLinkedList.add("Hello 5");

        System.out.println(stringMyLinkedList);

        stringMyLinkedList.add("Hello 22", 1);

        System.out.println(stringMyLinkedList);

    }

    @Override
    public void add(E e) {
        if (isEmpty()) {
            this.root = new Node<>(e);
            size++;
        } else {
            Node<E> temp = this.root;
            while (true){
                if (temp.next == null){
                    temp.next = new Node<>(e);
                    size++;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    @Override
    public void add(E e, int index) {
        if (isEmpty() && index != 0){
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> temp = this.root;
            for (int i = 0; i < size; i++) {
                if (i == index - 1){
                    Node<E> right = temp.next;
                    temp.next = new Node<>(e, right);
                    size++;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    // TODO: 02.09.2020
    @Override
    public E set(E e, int index) {
        Node<E> current = this.root;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldValue = current.element;
        current.element = e;
        return oldValue;
    }


    @Override
    public E remove(int index) {
        return null;
    }

    // TODO: 02.09.2020
    @Override
    public E get(int index) {
        if (isEmpty() && index != 0) {
            throw new IndexOutOfBoundsException();
        }
        return listIterator(index).next();
    }


    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E>{
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

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}
