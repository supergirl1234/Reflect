package com;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class TestClssMethod {

    public static void main(String[] args) {

        try {
            Class class1=Class.forName("com.Test");
            Package package1=class1.getPackage();
            System.out.println("包名");
            System.out.println(package1.getName());

            System.out.println("父类名");
            Class superclass=class1.getSuperclass();
            System.out.println(superclass);
            System.out.println(superclass.getName());
            System.out.println(superclass.getSimpleName());


            System.out.println("继承的接口名");
            Class[] classInterface=class1.getInterfaces();
            for (Class c : classInterface) {
                System.out.println(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
interface IMessage {

}

interface IFruit {

}

///extends Object
class Test extends TestClssMethod implements IMessage, IFruit {

}