package pro.sky.java.course2.lesson8;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName, Double salary, Integer departmentId);

    boolean removeEmployee(String firstName, String lastName, Double salary, Integer departmentId);

    Employee findDepartmentMaxSalary(Integer departmentId);

    Employee findDepartmentMinSalary(Integer departmentId);

    List<String> printDepartmentEmployees(Integer departmentId);

    List<String> printEmployeesByDepartment();
}
