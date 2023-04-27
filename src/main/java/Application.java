import model.City;
import model.Employee;
import service.EmployeeDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "14042017Katya!";
        final String url = "jdbc:postgresql://localhost:5432/employee";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, 4);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String nameOfEmployee = "Name: " + resultSet.getString("first_name");
                String lastNameOfEmployee = "Last_name: " + resultSet.getString("last_name");
                String genderOfEmployee = "Last_name: " + resultSet.getString("gender");
                String cityOfEmployee = "City_id: " + resultSet.getInt("city_id");

                // Выводим данные в консоль
                System.out.println(nameOfEmployee);
                System.out.println(lastNameOfEmployee);
                System.out.println(genderOfEmployee);
                System.out.println(cityOfEmployee);

            }
        }

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Создаем объект класса BookDAOImpl
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            Employee employee = new Employee( "Eva", "Ivanova", "f", 30, new City(6));

            // Вызываем метод добавления объекта
            employeeDAO.create(employee);

            // Создаем список наполняя его объектами, которые получаем
            // путем вызова метода для получения всех элементов таблицы
            List<Employee> list = new ArrayList<>(employeeDAO.readAllEmployee());

            employeeDAO.updateById(1, "Evunov");

            employeeDAO.deleteById(13);

            // Выведем список в консоль
            for (Employee employees : list) {
                System.out.println(employees);
            }

        }
    }
}