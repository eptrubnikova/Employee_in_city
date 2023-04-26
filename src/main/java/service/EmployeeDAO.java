package service;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void create (Employee employee);
    Employee readById (int id);
    List<Employee> readAllEmployee();
    void updateById (int id, String last_name);
    void deleteById (int id);

}
