package com;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class TestField {

    public static void main(String[] args) {
        try {
            Class classes=Class.forName("com.Students");
            //获取全部属性
            System.out.println("获取Students类的所有公开属性");
          //getFields()只能获取（包括父类的）公开（public）属性
           Field[] fields= classes.getFields();
           for(Field p:fields){
               System.out.println(p);

           }

           //getDeclaredFields() 不管公开还是私有的属性都能获取，只能获取本类的属性
            System.out.println("获取Students本类的属性");
            Field[] fields1= classes.getDeclaredFields();
            for(Field p:fields1){

                System.out.println(p);
            }


            //获取某个指定的属性
            System.out.println("获取指定属性");
            Field field1=classes.getDeclaredField("teacher");
            System.out.println(field1);
            Field field2=classes.getDeclaredField("major");
            System.out.println(field2);

            //获取属性的类型 getType
            System.out.println(field1.getType());

            //实例化一个对象
            Students students1=(Students) classes.newInstance();
            System.out.println("实例化后的信息："+students1);
            field1.set(students1,"李四");
            System.out.println("field1赋值之后："+students1);
            Object value=field1.get(students1);
            System.out.println("通过field1 get之后获取值："+value);

            field2.setAccessible(true);//取消封装
            //因为field2 是major 在Students中major是private私有的，若不取消封装，则无法通过下面的方法给major进行赋值
            field2.set(students1,"计算机");
            System.out.println("field2赋值之后："+students1);
            Object value2=field2.get(students1);
            System.out.println("通过field2 get之后获取值："+value2);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
