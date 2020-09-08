package com.company.stack;

public interface Stack<E> {
    E push(E e);
    E pop();
    E peek();
    boolean empty();
    int search(E e);
}
