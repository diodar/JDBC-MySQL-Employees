package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReadRepository {

    List<Employee> list;

    public List<Employee> readEmployees() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();
            String sql = "SELECT e.id, lastName, firstName, birthDate, p.name AS positionName, phone, salary FROM " + Constants.TABLE_EMPLOYEES + " e \n" +
                    "INNER JOIN " + Constants.TABLE_POSITIONS + " p ON e.positionId = p.id;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setLastName(rs.getString("lastName"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setBirthDate(rs.getString("birthDate"));
                employee.setPositionName(rs.getString("positionName"));
                employee.setPhone(rs.getString("phone"));
                employee.setSalary(rs.getDouble("salary"));

                list.add(employee);
            }
            return list;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
