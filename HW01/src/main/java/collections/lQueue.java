package main.java.collections;

import java.util.NoSuchElementException;

/**
 * Created by t0lia on 19.12.15.
 */
public class lQueue<T> implements IQueue<T>{
    private Node<T> head, tail;
    private int size;


    public lQueue() {
        head = tail = new Node<>();
        size = 0;
    }

    @Override
    public void add(T t) {
        if (t == null) {
            throw new NullPointerException();
        }

        Node<T> node = new Node<>();
        node.elem = t;

        tail.next = node;

        tail = node;
        size++;
    }

    @Override
    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T result = head.next.elem;
        head.next.elem = null;

        head = head.next;

        return result;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    class Node<T> {
        T elem;
        Node<T> next;
    }
}
