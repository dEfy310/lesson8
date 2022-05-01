package pro.sky.java.course2.lesson8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class EmployeeDepartmentController {
    private final EmployeeService employeeService;

    public EmployeeDepartmentController(EmployeeService employeeServiceImpl) {
        this.employeeService = employeeServiceImpl;
    }

    @GetMapping("/max-salary")
    public Employee findDepartmentMaxSalary(@RequestParam Integer departmentId) {
        return employeeService.findDepartmentMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee findDepartmentMinSalary(@RequestParam Integer departmentId) {
        return employeeService.findDepartmentMinSalary(departmentId);
    }

    @GetMapping("/all/department")
    public Set<String> getDepartmentEmployees(@RequestParam Integer departmentId) {
        return employeeService.getDepartmentEmployees(departmentId);
    }

    @GetMapping("/all")
    public Set<String> getEmployeesByDepartment() {
        return employeeService.getEmployeesByDepartment();
    }
}
