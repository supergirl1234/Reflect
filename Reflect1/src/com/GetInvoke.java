package com;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Per{


    private String name;
    private int age;
    private String address;

    public Per() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Per{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
public class GetInvoke {

    public static void main(String[] args) {

       Class<?> cls= Per.class;

        try {
            /*创建实例化对象*/
            Per per= (Per) cls.newInstance();
            /*拿到setName的方法*/
           Method method= cls.getMethod("setName", String.class);
           /*通过invoke进行调用*/
            method.invoke(per,"李四");

            System.out.println(per);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
