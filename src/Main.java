public class Main {

    public static void main(String[] args) {
       /*
       printAllEmploee() - получить список всех сотрудников
       findEmploee(String fullName) - поиск сотрудников по Ф.И.О
       findSalary(int salary) - поиск сотрудника по зарплате
       findMaxSalary() - поиск максимальной зарплаты всех сотрудников, возращает значение типа int
       findMinSalary() - поиск минимальной зарплаты всех сотрудников, возращает значение типа int
       int amountOfCosts() - сумма затрат на всех сотрудников
       averageSalary() - средняя зарплата
       salaryIndexation(int indexationPercentage) - индексация ЗП у всех сотрудников, где indexationPercentage процент
       индексации
       findDepartmentEmployees(int department) - получить сотрудников в отделе
       findMaxSalaryInDepartment(int department) - поиск максимальной ЗП в отделе
       findMinSalaryInDepartment(int department) - поиск минимальной ЗП в отделе
       amountOfCostsInDepartment(int department) - сумма затрат на ЗП в отделе
       averageSalaryDepartment(int department) - средняя ЗП в отделе
       salaryIndexationInDepartment(int indexationPercentage, int department) - индексация ЗП в отделе, где int indexationPercentage
       процент прибавки, int department - номер отдела.
       salaryRangeIsSmaller(int salary) - поиск сотрудников с зарплатой меньше числа salary
       salaryRangeIsLarger(int salary) - поиск сотрудников с зарплатой больше числа salary
        */
        EmployeeBook employeeBook = EmployeeBook.getEmployeeBook();
        System.out.println(employeeBook.getCountId());
        System.out.println("++++++ID++++++++");
        employeeBook.printAllEmployee();
        System.out.println("+++++++++Список++++++++");
        employeeBook.findEmployee("Музафаров Петр Евгеньевич");
        System.out.println("+++++++++Поиск+++++++++");
        System.out.println(employeeBook.findMaxSalary());
        System.out.println(employeeBook.findMinSalary());
        System.out.println("+++++++++Max/Min salary++++++++++");
        System.out.println("Сумма затрат на ЗП в месяц: " + employeeBook.amountOfCosts());
        System.out.println("Средняя зарплата: " + employeeBook.averageSalary());
        System.out.println("+++++++++Общие затраты + средняя+++++++++++");
        employeeBook.findMaxSalaryInDepartment(3);
        employeeBook.findMinSalaryInDepartment(2);
        System.out.println("+++++++++Max/Min по отделу++++++++");
        System.out.println("Сумма затрат на ЗП по отделу " + employeeBook.amountOfCostsInDepartment(3));
        System.out.println("Средняя зарплата по отделу: " + employeeBook.averageSalaryDepartment(5));
        employeeBook.salaryIndexationInDepartment(9, 2);
        System.out.println("+++++++Общие затраты по отделу, средняя по отделу+++++++");
        employeeBook.salaryIndexation(3);
        employeeBook.printAllEmployee();
        System.out.println("Индексация у всех + список");
        employeeBook.findDepartmentEmployees(2);
        System.out.println("++++индексация по отделу+++++++");
        employeeBook.salaryRangeIsSmaller(90_000);
        System.out.println("+++++++диапазон поиска боьше/меньше по ЗП+++++++");
        employeeBook.salaryRangeIsLarger(90_000);
        System.out.println("+++++++удаление сотрудника++++++++");
        employeeBook.removeEmployee("Машарская Светлана Николаевна");
        employeeBook.addEmployee(new Employee("Щербакова Ольга Александровна", 2, 81_000));
        employeeBook.printAllEmployee();
        System.out.println("++++++++Изменене зп сотрудника++++++");
        employeeBook.changeEmployeeDataSalary("Ветчанин Роман Алексеевич", 81_000);
        System.out.println("++++++Изменение отдела сотрудника++++++++");
        employeeBook.changeEmployeeDataDepartment("Ветчанин Роман Алексеевич", 1);
        System.out.println("++++++++Сотрудники в отделе++++++++++++");
        employeeBook.printTeam();
    }
}