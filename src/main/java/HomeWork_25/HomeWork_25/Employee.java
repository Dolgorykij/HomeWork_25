package HomeWork_25.HomeWork_25;

import java.util.Objects;

public class Employee {

        private String firstname;
        private String lastName;
        private int department;
        private int salary;

        public String fullName() {
            return firstname + " " + lastName;
        }

        public Employee(String firstname, String lastName, int department, int salary) {
            this.firstname = firstname;
            this.lastName = lastName;
            this.department = department;
            this.salary = salary;
        }

        public Employee(String firstname, String lastName) {
            this.firstname = firstname;
            this.lastName = lastName;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getDepartment() {
            return department;
        }

        public void setDepartment(int department) {
            this.department = department;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return department == employee.department && salary == employee.salary && Objects.equals(firstname, employee.firstname) && Objects.equals(lastName, employee.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstname, lastName, department, salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstname='" + firstname + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", department=" + department +
                    ", salary=" + salary +
                    '}';
        }
    }
