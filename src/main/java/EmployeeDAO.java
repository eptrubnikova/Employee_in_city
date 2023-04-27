import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee create (Employee employee);
    Employee readById (int id);
    List<Employee> readAllEmployee();
    void updateById (Employee employee);
    void delete (Employee employee);

}
