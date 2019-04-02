package com;

import javafx.scene.shape.Arc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Author:Fanleilei
 * Created:2019/4/1 0001
 */
public class TestEmp {

    public static void main(String[] args) {

        //Emp emp=new Emp();

        String content = "emp.name:Jack|emp.age:12|emp.job:学生";//如果字符串的分隔符不是这种，那该咋办
        //Map<String,Object> map=Split1(content);
        Map<String, Object> map = Split2(content, new Function<String, Map<String, Object>>() {//知道了字符串之后，然后就在这里面进行分割
            @Override
            public Map<String, Object> apply(String s) {
                Map<String, Object> map = new HashMap<>();
                String[] element = content.split("\\|");
                for (String p : element) {
                    String[] object = p.split(":");
                    //取得属性
                    String attribute = object[0].split("\\.")[1];
                    //取得属性值
                    String value = object[1];
                    //set+属性名
                    String Attribute = SetAttribute(attribute);
                    map.put(Attribute, value);
                }
                return map;
            }
        });
        //SetValue(emp,map);
        SetValue(Emp.class, map);


    }

   /* //将内容进行拆分
    public static Map<String,Object> Split1(String content){

        Map<String,Object> map=new HashMap<>();
        if(content!=null||content.length()>0){
            String[] element=content.split("\\|");
            for(String p:element){
                String[]  object=p.split(":");
                //取得属性
                String attribute=object[0].split("\\.")[1];
                //取得属性值
                String value=object[1];
                //set+属性名
                String Attribute=SetAttribute(attribute);
                map.put(Attribute,value);
            }
        }
        return   map;
    }*/

    //在还没有自字符串的分隔符的情况下进行拆分字符串
    public static Map<String, Object> Split2(String content, Function<String, Map<String, Object>> function) {
      Map<String, Object> map = function.apply(content);

        /*  if (content!=null||content.length()>0){


             String[] element = content.split("\\|");
            for(String p:element){
                String[] object = p.split(":");
                //取得属性
                String attribute = object[0].split("\\.")[1];
                //取得属性值
                String value = object[1];
                //set+属性名
                String Attribute = SetAttribute(attribute);
                map.put(Attribute, value);
            }
        }*/
        return map;
    }


    //将属性的首字母变成大写
    public static String Upper(String attribute){
        String Attribute=attribute.substring(0,1).toUpperCase()+
                (attribute.length()==1?" ":attribute.substring(1));
        return Attribute;

    }
    //直接通过属性得到set方法 set+Attribute
    public static String SetAttribute(String attribute){

        return "set"+Upper(attribute);


    }

   /* //set方法
    public static void SetValue(Object object,Map<String,Object> map)  {


          Class classes=object.getClass();

        //下面这种方法不适合int/Integer类型的变量，这种变量要单独处理

            Method[] method = classes.getMethods();


            for (Method p : method) {
                String method1 = p.getName();
                if (map.containsKey(method1)) {

                    try {
                        p.invoke(object, map.get(method1));//直接赋值
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }


        System.out.println(object.toString());

    }*/


    //set方法
    /*public static void SetValue(Object object,Map<String,Object> map){

        Class classes=object.getClass();
        Method[] method=classes.getMethods();


        //int/Integer变量要单独处理

        for(Method p:method){
            String method1=p.getName();
            if(map.containsKey(method1)) {

                Parameter parameter = p.getParameters()[0];
                try {
                    if (parameter.getType() == Integer.class) {
                            p.invoke(object, Integer.parseInt(String.valueOf(map.get(method1))));

                    } else {

                            p.invoke(object, map.get(method1));//直接赋值

                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

        System.out.println(object.toString());

    }*/


    //set方法
  public static void SetValue(Class object,Map<String,Object> map)  {




        //int/Integer变量要单独处理
        try {
            Method[] method = object.getMethods();

            Object obj=object.newInstance();
            for (Method p : method) {
                String method1 = p.getName();
                if (map.containsKey(method1)) {

                    Parameter parameter = p.getParameters()[0];


                        if (parameter.getType() == Integer.class) {
                            p.invoke(obj, Integer.parseInt(String.valueOf(map.get(method1))));

                        } else {

                            p.invoke(obj, map.get(method1));//直接赋值

                        }
                }
            }
            System.out.println(obj.toString());

        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }


    }

}
