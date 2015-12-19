package main.java.collections;

import java.util.NoSuchElementException;

/**
 * Resizing-array stack implementation
 * Created by t0lia on 19.12.15.
 */
public class aStack<T> implements IStack<T> {
    private static final int INITIAL_CAPACITY = 2;
    private T[] container;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public aStack() {
        container = (T[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size < capacity / 4) {
            resize(capacity / 2);
        }

        T result = container[--size];
        container[size] = null;
        return result;
    }

    @Override
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (size() == capacity) {
            resize(2 * capacity);
        }
        container[size++] = t;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int capacity) {
        this.capacity = capacity;
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < copy.length && i < container.length; i++) {
            copy[i] = container[i];
        }
        container = copy;
    }
}
