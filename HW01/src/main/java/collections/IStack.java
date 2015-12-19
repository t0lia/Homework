package main.java.collections;

/**
 * Created by t0lia on 19.12.15.
 */
public interface IStack<T> {
    boolean isEmpty();
    T pop();
    void push(T t);
    int size();
}
