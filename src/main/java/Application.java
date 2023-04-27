import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee("Eva", "Ivanova", "f", 30, 6);
        employeeDAO.create(employee);

        System.out.println(employeeDAO.readById(3));

        List<Employee> list = employeeDAO.readAllEmployee();

        for (Employee employees : list) {
            System.out.println(employees);
        }

        Employee employee1 = new Employee("Vera", "Penkina", "f", 35, 5);
        employeeDAO.updateById(employee1);

        employeeDAO.delete(employee);
    }
}
