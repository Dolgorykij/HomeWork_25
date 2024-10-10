package HomeWork_25.HomeWork_25;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
    @GetMapping("/add")
    public Employee add (@RequestParam ("firstName") String firstName,
                         @RequestParam ("lastName") String lastName,
                         @RequestParam ("department") int department,
                         @RequestParam ("salary") int salary) {
        return employeeService.add(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
        // try {
        // final Employee employee = employeeService.add(firstName,lastName);
        // return firstName + lastName;

        // } catch (EmployeeAlreadyAddedException e) {
        //  return "Пользователь" + firstName + " " + lastName + " уже добавлен";
        // }
    }

    @GetMapping("/remove")
    public Employee remove (@RequestParam   ("firstName") String firstName,
                            @RequestParam ("lastName")  String lastName) {
        return employeeService.remove(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }
    @GetMapping("/find")
    public Employee find    (@RequestParam  ("firstName") String firstName,
                             @RequestParam  ("lastName")  String lastName,
                             @RequestParam ("department") int department,
                             @RequestParam ("salary") int salary) {
        return employeeService.find(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
        //try {
        // final Employee employee = employeeService.find(firstName, lastName);
        // return employeeService.remove(firstName,lastName);
        //  }   catch (EmployeeNotFoundException e) {
        //  return employeeService.remove(firstName,lastName);
        //  }

    }
    @GetMapping("/workers")
    public List<Employee> workers () {
        return employeeService.workerks();
    }

}

