package com;

import java.util.Date;

public class CreateObject {

    public static void main(String[] args) throws Exception {


        /*1.获取类的Class对象*/
        Class<Date> cls= (Class<Date>) Class.forName("java.util.Date");
        /*2.通过反射取得Date的实例化对象*/
        Date date=cls.newInstance();
        System.out.println(date);

        Date date1=cls.newInstance();
        System.out.println(date==date1);//false
    }
}
