package com.p2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class TestEmp {
    public static void main(String[] args) {

        Emp emp=new Emp();
        String content= "emp.ename:Jack|emp.job:测试工程师|emp.age:34";
        ObjectUtil objectUtil=new ObjectUtil();
        Map<String,Object> map=objectUtil.parseAttributeAndValue(content);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            objectUtil.setObjectValue(emp, entry.getKey(), entry.getValue());
        }
        System.out.println(emp);


    }
}

class ObjectUtil{

    public Map<String,Object> parseAttributeAndValue(String content){
        Map<String, Object> attributeAndValueMap = new HashMap<>();
        if(content!=null||content.length()>0){
            //value=emp.ename：Jack|emp.job:测试工程师

            String[] pairs=content.split("\\|");
            //emp.ename：Jack
            //emp.job:测试工程师
            for(String p:pairs){
                String[] attributeValue= p.split(":");
                String attributeTemp = attributeValue[0];
                int index=attributeTemp.indexOf(".");
                if(index!=-1){

                    String attribute=attributeTemp.substring(index+1);
                    attribute=
                            attribute.substring(0,1)
                                    .toLowerCase()
                                    +(attribute.length()==1?"":attribute.substring(1));
                    String value = attributeValue[1];
                    attributeAndValueMap.put(attribute,value);
                }


            }
        }

        return attributeAndValueMap;


    }

    public void setObjectValue(Object object,String attribute,Object value){


        Class classes=object.getClass();
        try {
            Method[] methods=classes.getMethods();
            Method method=null;
            for(Method p:methods){
                if(p.getName().equals("set"+attribute)){
                    method=p;
                }

            }

        //单独处理Integer

            Parameter parameter=method.getParameters()[0];
            if(parameter.getType()==Integer.class){
                method.invoke(object,Integer.parseInt(String.valueOf(value)));
            } else{

                method.invoke(object,value);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
        }


    }

    public Object getObjectValue(Object object,String attribute){

        Class classes=object.getClass();
        try {

            //获取get方法
            Method method=classes.getMethod("set"+attribute);
            //调用get方法
            return method.invoke(object);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
