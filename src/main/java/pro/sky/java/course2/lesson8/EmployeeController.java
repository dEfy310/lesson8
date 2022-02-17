package pro.sky.java.course2.lesson8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }


    @GetMapping("/employee/add")
    public boolean addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                               @RequestParam Double salary, @RequestParam Integer departmentId) {
        return employeeServiceImpl.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/employee/remove")
    public boolean removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                  @RequestParam Double salary, @RequestParam Integer departmentId) {
        return employeeServiceImpl.removeEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee findDepartmentMaxSalary(@RequestParam Integer departmentId) {
        return employeeServiceImpl.findDepartmentMaxSalary(departmentId);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee findDepartmentMinSalary(@RequestParam Integer departmentId) {
        return employeeServiceImpl.findDepartmentMinSalary(departmentId);
    }

    @GetMapping(path = "/departments/all/department")
    public List<String> printDepartmentEmployees(@RequestParam Integer departmentId) {
        return employeeServiceImpl.printDepartmentEmployees(departmentId);
    }

    @GetMapping(path = "/departments/all")
    public List<String> printEmployeesByDepartment() {
        return employeeServiceImpl.printEmployeesByDepartment();
    }
}
