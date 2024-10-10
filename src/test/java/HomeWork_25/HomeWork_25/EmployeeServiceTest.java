package HomeWork_25.HomeWork_25;

import HomeWork_25.HomeWork_25.Exception.EmployeeAlreadyAddedException;
import HomeWork_25.HomeWork_25.Exception.EmployeeNotFoundException;
import HomeWork_25.HomeWork_25.Exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.aot.hint.TypeReference.listOf;


public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();
    private Employee employee1;

    @Test
    public void testAddEmployee () {
        assertThat(employeeService.workerks()).size().isEqualTo(4);
        var employee1 = employeeService.add("Гера","Герадотов",2,7500);
        assertThat(employee1.getFirstname()).isEqualTo("Гера");
        assertThat(employee1.getLastName()).isEqualTo("Герадотов");
        assertThat(employee1.getDepartment()).isEqualTo(2);
        assertThat(employee1.getSalary()).isEqualTo(7500);
        assertThat(employeeService.workerks()).contains(employee1);
    }
    //@BeforeEach
    //public void setUp() {
       // EmployeeService employeeService = new EmployeeService();
        //employee1 = employeeService.add("Гера","Герадотов",2,7500);
    //}

    @Test
    public void testAddEmployeeAlreadyAddedException() {
        var employee1 = employeeService.add("Гера","Герадотов",2,7500);
        assertThrows(EmployeeAlreadyAddedException.class,() -> employeeService.add("Гера","Герадотов",2,7500));
    }

    @Test
    public void testAddEmployeeStorageIsFullException() {
        var employee1 = employeeService.add("Гера","Герадотов",2,7500);
        assertThrows(EmployeeStorageIsFullException.class,()->employeeService.add("Гер","Герадот",2,7500));
    }

    @Test
    public void testFind () {
        var employee1 = employeeService.add("Гера","Герадотов",2,7500);
        assertThat(employeeService.workerks()).contains(employee1);
        var expected = "Гера" + " " + "Герадотов";
        assertThat(employee1.fullName()).isEqualTo(expected);
        var expected1 = List.of(
                new Employee("Гера","Герадотов",2,7500)
        );
        assertThat(employeeService.workerks().contains(employee1.fullName())).isEqualTo(expected1.contains(employee1.fullName()));
    }
    @Test
    public void testFindException () {
        assertThrows(EmployeeNotFoundException.class,()-> employeeService.add("Wer","Wersck",4,6));
    }
    @Test
    public void testRemove () {
        var employee1 = employeeService.add("Гера","Герадотов",2,7500);
        assertThat(employeeService.workerks()).contains(employee1);
        employeeService.remove("Гера","Герадотов");
        var expected = List.of(
            new Employee("Daniil" , "Viktorov" , 2 , 5800),
            new Employee("Daniluk" , "Papazoglo", 1 , 4000),
            new Employee("Tundra", "Vakytagin" , 3, 5000),
            new Employee("Oleg", "Shmatko" , 1, 3500)
        );
        var actual = employeeService.workerks();
        assertEquals(expected,actual);
    }
}
