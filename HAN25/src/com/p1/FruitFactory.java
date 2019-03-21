package com.p1;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */

//这种方法有缺陷，如果想增加一个类，那么也需要修改工厂类，修改太多，不方便
public class FruitFactory {
    public FruitFactory() {}

    public  IFruit getClass(String className){

            if("Apple".equals(className)){

                return  new Apple();
            }
            if("Orange".equals(className)){
                return  new Orange();
            }
            return  null;

    }


}
