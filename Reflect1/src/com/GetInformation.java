package com;

class Person {
}
interface INews{}
interface IMessage{}

class Children extends Person implements INews,IMessage{


}
public class GetInformation {

    public static void main(String[] args) {
        Class<?> cls=Children.class;
        /*取得父类信息*/
        System.out.println(cls.getSuperclass());
        /*取得父类信息的名字*/
        System.out.println(cls.getSuperclass().getName());

        System.out.println("继承的接口：");
        /*取得1继承的接口*/
        Class<?>[] Interfaces=cls.getInterfaces();
        for(Class item:Interfaces){

            System.out.println(item);
        }
    }
}
