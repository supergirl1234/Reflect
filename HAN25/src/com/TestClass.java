package com;

import java.util.Date;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */


//Class类是描述我们在java中定义的类
//Class类的对象是Class文件加载到JVM中的标识对象（类加载器）
public class TestClass {

    public static void main(String[] args) {

        Date date=new Date();
        Class classz=date.getClass();
        System.out.println(classz.getName());
        //对象实例化方法：1.new 构造方法   2.反序列化  3.反射 newInstance

        try {
            Date date1= (Date) classz.newInstance();
            System.out.println(date1);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }





    }
}
