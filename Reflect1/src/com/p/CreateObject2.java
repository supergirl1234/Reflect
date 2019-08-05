package com.p;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Parent {

    private String name;
    private Integer age;

    private Parent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class CreateObject2 {

    public static void main(String[] args) {

        Class<?> cls =Parent.class;
        /*获取构造方法*/
        try {
            /*Parent类中的构造方法是私有的，getDeclaredConstructor能够拿到该构造方法，但是不能实例化对象*/
            Constructor constructor = cls.getDeclaredConstructor(String.class, Integer.class);
            /*可以通过下面的方法实例化对象*/
            constructor.setAccessible(true);/*破坏封装性*/
            Parent parent = (Parent) constructor.newInstance("张三", 14);
            System.out.println(parent);
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}