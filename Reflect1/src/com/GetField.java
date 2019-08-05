package com;


import java.lang.reflect.Field;

class Stu{

    public String name;
    private Integer age;
    private String address;


    public Stu() {
    }

    public Stu(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}


class St extends  Stu{

    public String name1;
    private int age1;

}
public class GetField {

    public static void main(String[] args) {

        Class<?> cls = Stu.class;
        Field[] fields1 = cls.getFields();
        for (Field item : fields1) {

            System.out.println(item);
        }

        System.out.println("+++++++++++++++++++");
        Field[] fields2 = cls.getDeclaredFields();
        for (Field item : fields2) {

            System.out.println(item);
        }

        System.out.println("============================================");


        Class<?> cls2 = St.class;
        Field[] fields3 = cls2.getFields();
        for (Field item : fields3) {

            System.out.println(item);
        }

        System.out.println("+++++++++++++++++++");
        Field[] fields4 = cls2.getDeclaredFields();
        for (Field item : fields4) {

            System.out.println(item);
        }

        System.out.println("============================================");

        try {
            Stu stu= (Stu) cls.newInstance();
            Field field = cls.getField("name");
            System.out.println(field);

            /*给属性设置值*/
            field.set(stu,"张三");

            System.out.println(stu);
            /*取得属性的值*/
            Object o= field.get(stu);
            System.out.println(o);

            Class clss=field.getType();
            System.out.println(clss);

        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
