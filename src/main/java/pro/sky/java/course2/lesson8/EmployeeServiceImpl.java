package pro.sky.java.course2.lesson8;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ArrayList<Employee> employeeSet;

    public EmployeeServiceImpl() {
        this.employeeSet = new ArrayList<>();
    }

    public Employee createEmployee(String firstName, String lastName, Double salary, Integer departmentId) {
        return new Employee(firstName, lastName, salary, departmentId);
    }

    @Override
    public boolean addEmployee(String firstName, String lastName, Double salary, Integer departmentId) {
        return employeeSet.add(createEmployee(firstName, lastName, salary, departmentId));
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName, Double salary, Integer departmentId) {
        return employeeSet.remove(createEmployee(firstName, lastName, salary, departmentId));
    }

    @Override
    public Employee findDepartmentMaxSalary(Integer departmentId) {
        return employeeSet.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    @Override
    public Employee findDepartmentMinSalary(Integer departmentId) {
        return employeeSet.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    @Override
    public List<String> printDepartmentEmployees(Integer departmentId) {
        return employeeSet.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printEmployeesByDepartment() {
        return employeeSet.stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName() + " departmentId" + employee.getDepartmentId())
                .collect(Collectors.toList());
    }
}

