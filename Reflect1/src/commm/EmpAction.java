package commm;

public class EmpAction {

    private Emp emp=new Emp();

    public Emp getEmp() {
        return emp;
    }
    public void setValue(String value){
        BeanOperation.setBeanValue(this,value);

    }

}
