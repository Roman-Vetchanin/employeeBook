public class EmployeeBook {
    private final Employee[] employees;
    private int countId;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String fullName, int department, int salary) {
        if (countId >= employees.length) {
            throw new ArrayIndexOutOfBoundsException("Штат компании укомплектован");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[countId++] = newEmployee;
    }

    public void printAllEmploee() {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            System.out.println(employee.toString());
        }
    }

    public void findEmploee(String fullName) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getFullName().equals(fullName)) {
                System.out.println(employee.getFullName() + " => " + employee.getDepartment() + " => " + employee.getSalary());
            }
        }
    }

    public void findSalary(int salary) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == salary) {
                System.out.println(employee.getFullName() + " => " + employee.getDepartment() + " => " + salary);
            }
        }
    }

    public int findMaxSalary() {
        int maxSalary = employees[0].getSalary();
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() >= maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public int findMinSalary() {
        int minSalary = employees[0].getSalary();
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() <= minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
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
                System.out.println(employee.getFullName() + " =>" + employee.getSalary());
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
                System.out.println(i + 1 + " Ф.И.О " + employee.getFullName() + " =>" + employee.getSalary());
            }
        }
    }

    public void salaryRangeIsLarger(int salary) {
        for (int i = 0; i < countId; i++) {
            Employee employee = employees[i];
            if (salary < employee.getSalary()) {
                System.out.println(i + 1 + " Ф.И.О " + employee.getFullName() + " => " + employee.getSalary());
            }
        }
    }
    public static EmployeeBook getEmployeeBook() {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Музафаров Петр Евгеньевич", 1, 90_000);
        employeeBook.addEmployee("Щербакова Ольга Александровна", 2, 78_000);
        employeeBook.addEmployee("Князевская Марина Сергеевна", 2, 79_000);
        employeeBook.addEmployee("Мысин Александр Сергеевич", 1, 60_000);
        employeeBook.addEmployee("Ветчанин Роман Алексеевич", 2, 65_000);
        employeeBook.addEmployee("Назарова Наталья Александровна", 3, 50_000);
        employeeBook.addEmployee("Курьяков Павел Владимирович", 5, 150_000);
        employeeBook.addEmployee("Горюнова Елена Сергеевна", 4, 76_000);
        employeeBook.addEmployee("Рэдман Александра Андреевна", 3, 450_000);
        employeeBook.addEmployee("Машарская Светлана Николаевна", 2, 69_000);
        return employeeBook;
    }
}
