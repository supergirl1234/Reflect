package com;

/**
 * Author:Fanleilei
 * Created:2019/4/1 0001
 */
public class Emp {

    private String name;
   private Integer age;
    private String job;

    public void setName(String name) {
        this.name = name;
    }

   /* public void setAge(int age) {
        this.age = age;
    }*/

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

   /* public int getAge() {
        return age;
    }
*/

    public Integer getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
               ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
