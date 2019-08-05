


interface IFruit {
    void buy();

}

class Apple implements  IFruit{


    @Override
    public void buy() {
        System.out.println("buy Apple");
    }
}
class Strawberry implements  IFruit{


    @Override
    public void buy() {
        System.out.println("buy Strawberry");
    }
}

/*工厂方法模式*/
class Factory{

    public static IFruit getObject(String str){

        if(str.equals("Apple")){

            return new Apple();
        }
        if(str.equals("Strawberry")){
            return  new Strawberry();

        }
        return  null;
    }
}

/*将最初的工厂模式改写为反射型*/
class Factory2{

    public static IFruit getObject(String str){

        IFruit fruit=null;

        try {
            /*反射*/
            Class<IFruit> cls= (Class<IFruit>) Class.forName(str);
            fruit=cls.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return  fruit;
    }
}
public class FFactory {

    public static void main(String[] args) {

        IFruit  fruit=Factory.getObject("Apple");
        if(fruit!=null) {
            fruit.buy();
        }else{

            System.out.println("无不想买水果");
        }
        /*对于传统的工厂模式，如果要加入新的类，除了要添加新的类之外，还要改写Factory类的内容，不方便*/


        /*反射，如果使用了反射，则只需要添加新的类，Factory类不用变化*/
        IFruit  fruit2=Factory2.getObject("Apple");/**/
        fruit2.buy();
    }

}
