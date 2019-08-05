package com;

import java.lang.reflect.Constructor;



class Teacher{

    private Teacher() {
    }
    protected Teacher(String name) {
    }

    public Teacher(String name,int age) {
    }

}
public class GetConstrcutor {

    public static void main(String[] args) {
        Class<?> cls=Teacher.class;
        /*取得所有构造方法*/
       Constructor<?>[] constructor1= cls.getConstructors();/*只能获取Public权限的*/
       for(Constructor item:constructor1){
           System.out.println(item);

       }

        System.out.println("++++++++++++++++++++++");

        Constructor<?>[] constructor2= cls.getDeclaredConstructors();/*可以获取全部的*/
        for(Constructor item:constructor2) {
            System.out.println(item);

        }

    }
}
