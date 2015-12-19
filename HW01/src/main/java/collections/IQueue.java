package main.java.collections;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by t0lia on 19.12.15.
 */
public interface IQueue<T> {
    void add(T t);

    T remove();

    boolean isEmpty();

    int size();

}
