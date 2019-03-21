package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class TestConstructor {
    public static void main(String[] args) {

        try {
            Class class1=Class.forName("com.Person");
            System.out.println("获取全部构造方法：");
            //获取全部构造方法
            Constructor[] constructors=class1.getConstructors();
            for(Constructor p:constructors){
                System.out.println(p);
            }

            System.out.println("获取某个特定的构造方法");
            //获取某一个构造方法
            Constructor constructor=class1.getConstructor();
            System.out.println(constructor);
            Constructor constructor1=class1.getConstructor(String.class,int.class);
            System.out.println(constructor1);


            System.out.println("实例化对象");
            //构造对象
            //1.class.newInstance()  类里面一定要有无参构造方法
           Person person1= (Person) class1.newInstance();//newInstance()里面不带参数，则类里面一定要有无参构造方法
           System.out.println(person1);

           //2.construct.newInstance  获取构造方法的对象，执行构造对象的newInstance(参数值...)
           Person person2=(Person) constructor1.newInstance("张三",14);
            System.out.println(person2);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}

class Person{

    public String name;
    private int age;
    private String address;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
class Students extends Person{

    public String teacher;
    private String major;



    public String getTeacher() {
        return teacher;
    }

    public String getMajor() {
        return major;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Students{" +
                "teacher='" + teacher + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}