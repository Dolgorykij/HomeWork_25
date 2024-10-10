package HomeWork_25.HomeWork_25;

import HomeWork_25.HomeWork_25.Exception.EmployeeAlreadyAddedException;
import HomeWork_25.HomeWork_25.Exception.EmployeeNotFoundException;
import HomeWork_25.HomeWork_25.Exception.EmployeeStorageIsFullException;
import HomeWork_25.HomeWork_25.Exception.WrongNameException;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private static final Integer INITIAL_CAPACITY = 6;
    private final List<Employee> employeeList; //= new ArrayList<>(List.of(
    //new Employee("Daniil" , "Viktorov" , 2 , 5800),
    //new Employee("Daniluk" , "Papazoglo", 1 , 4000),
    // new Employee("Tundra", "Vakytagin" , 3, 5000),
    // new Employee("Oleg", "Shmatko" , 1, 3500)
    //));

    public EmployeeService() {
        this.employeeList = new ArrayList<>(INITIAL_CAPACITY);
        this.employeeList.add(new Employee("Daniil" , "Viktorov" , 2 , 5800));
        this.employeeList.add(new Employee("Daniluk" , "Papazoglo", 1 , 4000));
        this.employeeList.add(new Employee("Tundra", "Vakytagin" , 3, 5000));
        this.employeeList.add(new Employee("Oleg", "Shmatko" , 1, 3500));
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) throws EmployeeAlreadyAddedException {
        checkChar(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) { //&& StringUtils.isAlpha(employee.fullName())
            throw new EmployeeAlreadyAddedException("данный человек уже есть в списке");
        } else if (employeeList.size() > INITIAL_CAPACITY) {
            throw new EmployeeStorageIsFullException("Слишком много сотрудников");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, int department, int salary) throws EmployeeNotFoundException{
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Человек не найден");
        }
    }
    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException,EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName,  lastName, 0, 0);
        boolean removed = employeeList.removeIf(e -> e.getFirstname().equals(firstName) && e.getLastName().equals(lastName));
        if (removed) {
            employeeList.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Человек не найден");
        }
        //if (employeeList.contains(employee.fullName())) {
        //employeeList.remove(employee);
        //return employee;
        //} else {
        //throw new EmployeeNotFoundException("Человек не найден");
        //}
    }
    @Override
    public List<Employee> workerks() {
        return employeeList;
    }
    private void checkChar (String... values) {
        for (String value : values) {
            if (!StringUtils.isAlpha(value)) {
                throw new WrongNameException();
            }
        }
    }
}
