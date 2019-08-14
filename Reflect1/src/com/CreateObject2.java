package com;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Parent {
    private String name;
    private Integer age;
    public Parent(String name, Integer age) {
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

        Class<?> cls = Parent.class;
        /*获取构造方法*/
        try {
            Constructor constructor = cls.getConstructor(String.class, Integer.class);
            Parent parent = (Parent) constructor.newInstance("张三", 14);
            System.out.println(parent);
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
