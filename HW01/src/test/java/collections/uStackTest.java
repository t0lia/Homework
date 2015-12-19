package test.java.collections;

import main.java.collections.IStack;
import main.java.collections.uStack;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by t0lia on 19.12.15.
 */
public class uStackTest {
    IStack<Integer> iStack;
    IStack<String> sStack;

    @Before
    public void setUp() throws Exception {
        iStack = new uStack<>();
        sStack = new uStack<>();
    }

    @Test
    public void isEmpty_AddOneElemIntegerStack_false() throws Exception {
        iStack.push(1);
        boolean actual = iStack.isEmpty();
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void isEmpty_AddOneElemStringStack_false() throws Exception {
        sStack.push("");
        boolean actual = sStack.isEmpty();
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void isEmpty_newIntegerStack_true() throws Exception {
        boolean actual = iStack.isEmpty();
        boolean expected = true;
        assertEquals(actual, expected);
    }


    @Test
    public void pushAndPop_FromIntegerStack_rightElement() throws Exception {
        iStack.push(319);
        int actual = iStack.pop();
        int expected = 319;
        assertEquals(actual, expected);
    }

    @Test
    public void pushAndPop_FromIntegerStack_rightSequence() throws Exception {
        iStack.push(1);
        iStack.push(2);
        iStack.push(3);
        int[] actual = new int[]{iStack.pop(), iStack.pop(), iStack.pop()};
        int[] expected = new int[]{3, 2, 1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void size_threePush_sizeThree() throws Exception {
        iStack.push(1);
        iStack.push(2);
        iStack.push(3);
        int actual = iStack.size();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test(expected = NoSuchElementException.class)
    public void pop_emptyStack_Exception() throws Exception {
        iStack.pop();
    }
    @Test(expected = NullPointerException.class)
    public void push_nullObj_Exception() throws Exception {
        iStack.push(null);
    }
}