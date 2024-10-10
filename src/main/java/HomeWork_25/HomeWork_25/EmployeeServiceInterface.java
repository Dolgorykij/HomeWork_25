package HomeWork_25.HomeWork_25;

import HomeWork_25.HomeWork_25.Exception.EmployeeAlreadyAddedException;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName, int department, int salary);

    Employee find(String firstName, String lastName, int department, int salary);

    Employee remove(String firstName, String lastName);

    List<Employee> workerks();
}
