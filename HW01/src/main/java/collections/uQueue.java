package main.java.collections;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by t0lia on 19.12.15.
 */
public class uQueue<T> implements IQueue<T> {
    private final Queue<T> deque;

    public uQueue() {
        deque = new ArrayDeque<>();
    }

    public void add(T t) {
        deque.add(t);
    }

    public T remove() {
        return deque.remove();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

}
