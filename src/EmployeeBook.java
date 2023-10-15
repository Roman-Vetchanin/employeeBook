public class EmployeeBook {
    private final Employee[] employees;
    private int countId;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(Employee employee) {
        if (countId >= employees.length) {
            throw new ArrayIndexOutOfBoundsException("Штат компании укомплектован");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[countId++] = employee;
                break;
            }
        }

    }


    public void printAllEmployee() {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            System.out.println(employee);
        }
    }

    public void findEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee.getFullName().equals(fullName)) {
                System.out.println(employee);
            }
        }
    }

    public void findSalary(int salary) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == salary) {
                System.out.println(employee);
            }
        }
    }


    public Employee findMaxSalary() {
        int maxSalary = employees[0].getSalary();
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() >= maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    public Employee findMinSalary() {
        int minSalary = employees[0].getSalary();
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() <= minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public int amountOfCosts() {
        int summ = 0;
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            summ += employee.getSalary();
        }
        return summ;
    }

    public double averageSalary() {
        return (double) amountOfCosts() / employees.length;
    }

    public int getCountId() {
        return countId;
    }

    public void salaryIndexation(int indexationPercentage) {
        double percentage = 1 + ((double) indexationPercentage / 100);
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            employee.setSalary((int) (employee.getSalary() * percentage));
        }
    }

    public void findDepartmentEmployees(int department) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                System.out.println(employee);
            }
        }
    }

    public void findMaxSalaryInDepartment(int department) {
        int max = 0;
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                if (employee.getSalary() >= max) {
                    max = employee.getSalary();
                }
            }
        }
        findSalary(max);
    }


    public void findMinSalaryInDepartment(int department) {
        int min = employees[0].getSalary();
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                if (employee.getSalary() <= min) {
                    min = employee.getSalary();
                }
            }
        }
        findSalary(min);
    }

    public int amountOfCostsInDepartment(int department) {
        int summ = 0;
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                summ += employee.getSalary();
            }
        }
        return summ;
    }

    private int countDepartment(int department) {
        int count = 0;
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                count++;
            }
        }
        return count;
    }

    public double averageSalaryDepartment(int department) {
        return (double) amountOfCostsInDepartment(department) / countDepartment(department);
    }

    public void salaryIndexationInDepartment(int indexationPercentage, int department) {
        double percentage = 1 + ((double) indexationPercentage / 100);
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * percentage));
            }
        }
    }

    public void salaryRangeIsSmaller(int salary) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (salary >= employee.getSalary()) {
                System.out.println(employee);
            }
        }
    }

    public void salaryRangeIsLarger(int salary) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (salary < employee.getSalary()) {
                System.out.println(employee);
            }
        }
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println(employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, countId - i - 1);
                employees[countId - 1] = null;
                countId--;
                return;
            }
        }
    }
    public void changeEmployeeDataSalary (String fullName, int salary){
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employee.getFullName().equals(fullName)){
                employee.setSalary(salary);
                System.out.println(employee);
            }
        }
    }
    public void changeEmployeeDataDepartment (String fullName, int department){
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if(employee.getFullName().equals(fullName)){
                employee.setDepartment(department);
                System.out.println(employee);
            }
        }
    }

    public void printTeam() {
        for (int i = 1; i <=5 ; i++) {
            System.out.println("Team "+i+" : ");
            for (Employee employee:employees) {
                if (employee.getDepartment() == i) {
                    System.out.println("\t "+ employee.getId()+" "+ employee.getFullName()+" "+employee.getSalary());
                }
            }
        }
    }

    public static EmployeeBook getEmployeeBook() {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(new Employee("Бродова Светлана Викторовна", 1, 90_000));
        employeeBook.addEmployee(new Employee("Музафаров Петр Евгеньевич", 1, 90_000));
        employeeBook.addEmployee(new Employee("Князевская Марина Сергеевна", 2, 79_000));
        employeeBook.addEmployee(new Employee("Мысин Александр Сергеевич", 1, 60_000));
        employeeBook.addEmployee(new Employee("Ветчанин Роман Алексеевич", 2, 65_000));
        employeeBook.addEmployee(new Employee("Назарова Наталья Александровна", 3, 50_000));
        employeeBook.addEmployee(new Employee("Курьяков Павел Владимирович", 5, 150_000));
        employeeBook.addEmployee(new Employee("Горюнова Елена Сергеевна", 4, 76_000));
        employeeBook.addEmployee(new Employee("Рэдман Александра Андреевна", 3, 450_000));
        employeeBook.addEmployee(new Employee("Машарская Светлана Николаевна", 2, 69_000));
        return employeeBook;
    }
}
