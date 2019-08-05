package com;

public class IntegerClass {

    public static void main(String[] args) {
        Class<?> cls1=int.class;/*当JVM启动以后，八大基本对象都有他的Class对象*/
        Class<?> cls2=Integer.class;
        System.out.println(cls1);
        System.out.println(cls2);
    }
}
