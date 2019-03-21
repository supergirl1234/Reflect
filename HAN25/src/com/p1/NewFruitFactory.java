package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */

//这种用类来获取实例化对象的方法就改进了原来工厂模式中增加一个类的缺陷，
    //如果再增加一个类，也不需要修改该工厂类了
public class NewFruitFactory {
    public NewFruitFactory() {

    }

    public IFruit getClass(String className){

        IFruit fruit=null;
        try {
            fruit= (IFruit) Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }


}
