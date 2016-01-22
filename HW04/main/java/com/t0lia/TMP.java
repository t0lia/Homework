package com.t0lia;

import java.util.*;

/**
 * Created by t0lia on 16.01.16.
 */
interface someInt{
    void f();
}
class A{
    public static String name;
    public synchronized void foo1(){

        System.out.println("foo1:begin");
        try { Thread.sleep(1000);} catch (InterruptedException ignore) {/*NOP*/}
        System.out.println("foo1:finish");
    };
    public synchronized void foo2(){
        System.out.println("foo2:begin");
        try { Thread.sleep(1000);} catch (InterruptedException ignore) {/*NOP*/}
        System.out.println("foo2:finish");};
    public static synchronized void foo3(){
        System.out.println("foo3:begin");
        try { Thread.sleep(1000);} catch (InterruptedException ignore) {/*NOP*/}
        System.out.println("foo3:finish");
    };
}
class B {
    public synchronized void f(){
        A a = new A();
        int b = 2;
        synchronized (a){

        }
    }
}
public class TMP {

    public static void main(String[] args) {

        A a = new A();
        System.out.println(A.class.equals(a.getClass()));

    }
}
