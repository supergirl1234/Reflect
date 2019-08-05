package commm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOperation {

    public BeanOperation() {
    }

    /*emp.name:张三|emp.job:程序员*/
    public static void setBeanValue(Object actionObject,String value){

        /*1.先进行字符串拆分*/
        String[] temp1=value.split("\\|");//emp.name:张三
        for(int i=0;i<temp1.length;i++){
           String[]  temp2=temp1[i].split(":");//emp.name   张三
            String realValue=temp2[1];//张三    属性的真实值

            String realClassName=temp2[0].split("\\.")[0];//emp  真实类名称
            String realClassField=temp2[0].split("\\.")[1];//name  真实对象的属性


            /*通过反射取得xxAction中的真实对象*/
            Object realObject=getRealObject(actionObject,realClassName);

            try {

                //1.取得真实类的class对象
                Class<?> cls=realObject.getClass();
                //2.获取set方法
                String  setMethodName="set"+toUp(realClassField);
                Field field=cls.getDeclaredField(realClassField);/*获取属性*/
                field.setAccessible(true);
                Method method=cls.getDeclaredMethod(setMethodName,field.getType());

                //3.调用method*
                method.invoke(realObject,realValue);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

    }

    private static  Object getRealObject(Object object,String realClass){

        Class<?> cls=object.getClass();/*获得类对象*/
        String methodName="get"+toUp(realClass);//getEmp
        Object realObject=null;
        try {

            /*获取getEmp的Method*/
            Method method=cls.getDeclaredMethod(methodName);
            realObject=method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return  realObject;
    }


    /*将字符串转化为首字母大写*/
    private static String toUp(String str){
        return  str.substring(0,1).toUpperCase()+str.substring(1,str.length());

    }
}
