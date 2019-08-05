package commm;


class Person{


    public String name;
    public int age;
    public String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
public class Test {

    public static void main(String[] args) {

        Person person=new Person();
        person.setName("张三");
        person.setAge(12);
        person.setJob("程序员");
        System.out.println(person);
    }
}
