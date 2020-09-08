package com.company.stack;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E> {
    private Object[] objects = new Object[10];
    private int size;

    public static void main(String[] args) {
        Stack<String> eStack = new StackImpl<>();
        eStack.push("QWERTY");
        eStack.push("QWERTY2");
        eStack.push("QWERTY3");
        eStack.push("QWERTY4");
        eStack.push("QWERTY5");
//        System.out.println(eStack.peek());

//        System.out.println(eStack.pop());
//        System.out.println(eStack.pop());
//        System.out.println(eStack.pop());

        System.out.println(eStack.search("QWERTY"));

        System.out.println(eStack);
    }

    @Override
    public E push(E e) {
        objects[size++] = e;
        return e;
    }

    @Override
    public E pop() {
        if (empty()) {
            return null;
        }
        Object old = objects[size-1];
        objects[size - 1] = null;
        size--;
        return (E) old;
    }

    @Override
    public E peek() {
        return (E) objects[size - 1];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int search(E e) {
        for (int i = objects.length - 1, j = 0; i >= 0; i--) {
            if (objects[i] == null) continue;
            if (objects[i].equals(e)) {
                return j+1;
            } else {
                j++;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        return "StackImpl{" +
                "objects=" + Arrays.toString(objects) +
                ", size=" + size +
                '}';
    }
}
