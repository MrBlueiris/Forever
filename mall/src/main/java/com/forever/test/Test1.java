package com.forever.test;

public class Test1 {
    public static void main(String[] args) {

        Integer a=126,b=127,c=200,d=200,e=200;


        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(e));

    }
}
