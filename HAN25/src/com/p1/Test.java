package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */


public class Test {

    public static void main(String[] args) {

        IFruit fruit=new FruitFactory().getClass("Apple");
        fruit.eat();
    }
}
