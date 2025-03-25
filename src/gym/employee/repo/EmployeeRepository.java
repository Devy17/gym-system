package gym.employee.repo;

import gym.employee.domain.Employee;
import gym.membership.domain.Membership;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE employee_active = 'Y'";
        try (Connection conn = DBConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("part")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
