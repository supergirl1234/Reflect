package com;

import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */

//类的对象的产生模式一共有三种：
//1. 任何类的实例化对象可以通过Object类中的getClass()方法取得Class类对象。
//2. "类.class":直接根据某个具体的类来取得Class类的实例化对象。
//3. 使用Class类提供的方法:public static Class<?> forName(String className) throws
//ClassNotFoundException
public class Test1 {

    public static void main(String[] args) {
        Date date=new Date();
       Class classz= date.getClass();
        System.out.println(classz);


        //System.out.println(Date.class);
        //建议：一般在开发反射的代码中我们经常使用类的全限定名
        Class<java.util.Date> dateClass=java.util.Date.class;
        System.out.println(dateClass);


        Class dateClass1 = null;
        try {
             dateClass1  =Class.forName("java.util.Date");
        } catch (ClassNotFoundException e) {//注意这里的异常
            e.printStackTrace();
        }



        //比较这三个Class对象
        System.out.println("比较这三个Class对象");
        System.out.println(classz==dateClass);//true
        System.out.println(classz==dateClass1);//true
    }
}
