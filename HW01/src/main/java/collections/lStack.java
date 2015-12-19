package main.java.collections;

import java.util.NoSuchElementException;

/**
 * Linked-list stack implementation
 * Created by t0lia on 19.12.15.
 */
public class lStack<T> implements IStack<T> {
    private Node<T> top = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T result = top.elem;
        top = top.prev;
        size--;
        return result;

    }

    @Override
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        Node<T> node = new Node<>();
        node.elem = t;
        node.prev = top;
        top = node;
        size++;
    }

    @Override
    public int size() {
        return size;

    }
    class Node<T> {
        public T elem;
        public Node<T> prev;
    }
}

