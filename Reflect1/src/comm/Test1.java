package comm;

public class Test1 {
    public static void main(String[] args) {

        Class<?> cls=Test1.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent().getParent());


    }
}
