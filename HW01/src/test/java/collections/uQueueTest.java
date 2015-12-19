package test.java.collections;

import main.java.collections.IQueue;
import main.java.collections.uQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by t0lia on 19.12.15.
 */
public class uQueueTest {
    IQueue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new uQueue<>();
    }


    @Test
    public void isEmpty_AddOneElemQueue_false() throws Exception {
        queue.add(1);
        boolean actual = queue.isEmpty();
        boolean expected = false;
        assertEquals(actual, expected);
    }


    @Test
    public void isEmpty_newQueue_true() throws Exception {
        boolean actual = queue.isEmpty();
        boolean expected = true;
        assertEquals(actual, expected);
    }


    @Test
    public void addAndRem_FromQueue_rightElement() throws Exception {
        queue.add(319);
        int actual = queue.remove();
        int expected = 319;
        assertEquals(actual, expected);
    }

    @Test
    public void addAndRem_FromQueue_rightSequence() throws Exception {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int[] actual = new int[]{queue.remove(), queue.remove(), queue.remove()};
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void size_threeAdd_sizeThree() throws Exception {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int actual = queue.size();
        int expected = 3;
        assertEquals(actual, expected);
    }


    @Test(expected = NoSuchElementException.class)
    public void pop_emptyStack_Exception() throws Exception {
        queue.remove();
    }

    @Test(expected = NullPointerException.class)
    public void push_nullObj_Exception() throws Exception {
        queue.add(null);
    }
}