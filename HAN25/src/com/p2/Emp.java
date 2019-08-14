package com.p2;

/**
 * Author:Fanleilei
 * Created:2019/3/21 0021
 */
public class Emp {

    private String ename;
    private String job;
    private Integer age;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
