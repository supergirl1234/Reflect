package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class NewTest {

    public static void main(String[] args) {

        IFruit fruit1=new NewFruitFactory().getClass("com.p1.Apple");
        fruit1.eat();

        IFruit fruit2=new NewFruitFactory().getClass("com.p1.Orange");
        fruit2.eat();

        IFruit fruit3=new NewFruitFactory().getClass("com.p1.Walnut");
        fruit3.eat();
    }
}
