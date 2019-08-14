package com;

import javax.xml.crypto.Data;
import java.util.Date;

public class Test1 {

    public static void main(String[] args) {

        /*根据类正向产生对象*/
        Date date=new Date();
        System.out.println(date);

       /*
       * 反射
       * */
       //1.类对象.getClass
        System.out.println(date.getClass());
        //2.类名称.class
        System.out.println(Date.class);
        //3.Class.forName(String className)
        try {
            System.out.println(Class.forName("java.util.Date"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*任何一个类的class对象有且只有一个*/
        System.out.println(date.getClass()==Date.class);//true
        try {
            System.out.println(date.getClass()==Class.forName("java.util.Date"));//true

            System.out.println(Class.forName("java.util.Date")==Date.class);//true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
