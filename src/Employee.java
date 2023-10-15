public class Employee {
    private String fullName;

    private int department;
    private int salary;

    private int id;
    private static int counter = 1;


    public Employee(String fullName, int department, int salary){
        this.fullName =fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }
    public String getFullName() {
        return fullName;
    }
    @Override
    public String toString(){
        return "ID "+id+" Ф.И.О: " + fullName + " отдел: " + department + " зарплата " + salary;
    }
    public int getSalary(){
        return salary;
    }

    public int getDepartment() {
        return department;
    }
    public int getId(){
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
}
