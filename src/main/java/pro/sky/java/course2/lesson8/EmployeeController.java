package pro.sky.java.course2.lesson8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam Double salary, @RequestParam Integer departmentId) {
        return employeeService.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public boolean removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                  @RequestParam Double salary, @RequestParam Integer departmentId) {
        return employeeService.removeEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping
    public Set<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
