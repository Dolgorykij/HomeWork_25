package HomeWork_25.HomeWork_25;

import HomeWork_25.HomeWork_25.Exception.EmployeeAlreadyAddedException;
import HomeWork_25.HomeWork_25.Exception.EmployeeNotFoundException;
import HomeWork_25.HomeWork_25.Exception.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName, int department, int salary) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee find(String firstName, String lastName, int department, int salary) throws EmployeeNotFoundException;

    Employee remove(String firstName, String lastName);

    List<Employee> workerks();
}
