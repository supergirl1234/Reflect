package com;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

class Student {


    public Student() {

    }


    public void say() {


    }
    public void sleep(){


    }
    private  void eat(){


    }
}
class Xiqming extends Student{

    public Xiqming() {

    }

    public void say1(){


    }
    public void sleep1(){


    }

    private  void eat1(){


    }
}
public class GetMethod {

    public static void main(String[] args) {

        Class<?> cls=Xiqming.class;
       Method[] methods1=cls.getMethods();
       for(Method item:methods1){
           System.out.println(item);

       }

        System.out.println("++++++++++++++++++++");

        Method[] methods2=cls.getDeclaredMethods();
        for(Method item:methods2){
            System.out.println(item);

        }

        System.out.println("++++++++++++++++++++");

        Constructor[] constructors1=cls.getConstructors();
        for(Constructor item:constructors1){

            System.out.println(item);
        }

        System.out.println("++++++++++++++++++++");

        Constructor[] constructors2=cls.getDeclaredConstructors();
        for(Constructor item:constructors2){

            System.out.println(item);
        }
    }
}
