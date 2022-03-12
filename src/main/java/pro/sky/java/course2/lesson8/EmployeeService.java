package pro.sky.java.course2.lesson8;

import java.util.Set;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Double salary, int departmentId);

    boolean removeEmployee(String firstName, String lastName, Double salary, int departmentId);

    Employee findDepartmentMaxSalary(int departmentId);

    Employee findDepartmentMinSalary(int departmentId);

    Set<String> printDepartmentEmployees(int departmentId);

    Set<String> printEmployeesByDepartment();

    Set<Employee> getAllEmployees();
}
