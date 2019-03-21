package com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class TestMethod {

    public static void main(String[] args) {
        try {
            Class clases = Class.forName("com.Person");

            System.out.println("获取所有的普通方法");
            //1.获取Person类中的所有普通方法
           Method[] methods = clases.getMethods();
           for (Method m : methods) {
               System.out.println(m);
           }

            System.out.println("获取某个方法");
           //获取某个方法
             //获取set方法
            Method setmethod=clases.getMethod("setName",String.class);
            System.out.println(setmethod);

            //调用方法
            //利用获取的对象方法给对象赋值
            Person person1= (Person) clases.newInstance();
            Object object=setmethod.invoke(person1,"张三");
            System.out.println(person1);


            //获取get方法
            Method method1=clases.getMethod("getName");
            System.out.println(method1);
            Object o=method1.invoke(person1);
            System.out.println(o);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
