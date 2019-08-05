package commm;

public class EmpActionTest {

    public static void main(String[] args) {

        String value="emp.name:张三|emp.job:程序员";
        EmpAction empAction=new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
