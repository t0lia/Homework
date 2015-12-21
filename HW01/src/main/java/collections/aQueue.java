package main.java.collections;

import java.util.NoSuchElementException;

/**
 * Created by t0lia on 19.12.15.
 */
public class aQueue<T> implements IQueue<T> {
    private static final int INITIAL_CAPACITY = 16;
    private T[] container;
    private int capacity;
    private int head, tail;
    private int size;

    @SuppressWarnings("unchecked")
    public aQueue() {
        container = (T[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        head = tail = -1;
        size = 0;
    }

    @Override
    public void add(T t) {
        if (t == null) {
            throw new NullPointerException();
        }

        if (size == capacity) {
            resize(capacity*2);
            tail++;
        } else if (size == 0) {
            tail = head = 0;
        } else {
            tail = (tail + 1) % capacity;
        }
        container[tail] = t;
        size++;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size < capacity/4) {
            resize(capacity/2);
        }

        T result = container[head];
        container[head] = null;
        head = (head + 1) % capacity;
        size--;
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

    private void print() {
        for (T t : container) {
            if (t != null) {
                System.out.print(t.toString() + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private void resize(int copyCapacity) {
        T[] copy = (T[]) new Object[copyCapacity];
        capacity = copyCapacity;

        for (int i = 0, j = head; i < size; i++) {
            copy[i] = container[head];
            head++;
            head %= capacity;
        }


        container = copy;
        head= 0;
        tail = size - 1;


    }

    public static void main(String[] args) {
        aQueue<Integer> q = new aQueue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.print();
        q.add(6);
        q.print();
        q.remove();
        q.print();
        q.remove();
        q.print();
        q.remove();
        q.print();
        q.remove();
        q.print();
        q.remove();
        q.print();
        q.remove();
        q.print();
//        q.add(5);
        //System.out.println( q.remove());
//        for (int i = 0; i < q.container.length; i ++) {
//            System.out.println(q.container[i]);
//        }

    }
}
