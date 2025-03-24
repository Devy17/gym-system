package gym.employee.repo;

import gym.employee.domain.Employee;
import jdbc.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepository {
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees" +
                "(id, name, part) " +
                "VALUES (employee_seq.nextval, ?, ?)";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getPart());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
