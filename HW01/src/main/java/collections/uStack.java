package main.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack decorator of java.util.ArrayDeque
 * Created by t0lia on 19.12.15.
 */
public class uStack<T> implements IStack<T>{
    private final Deque<T> deque;
    public uStack() {
        deque = new ArrayDeque<>();
    }
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    public T pop() {
        return deque.pop();
    }
    public void push(T t){
        deque.push(t);
    }
    public int size() {
        return deque.size();
    }
}
