package gym.employee.repo;

import gym.employee.domain.Employee;
import jdbc.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    // 직원 조회
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("id"));
                employee.setEmployeeName(rs.getString("name"));
                employee.setEmployeePart(rs.getString("part"));

                // ActiveStatus 값을 "Y" 또는 "N"으로 변환
                String activeStatus = rs.getBoolean("ActiveStatus") ? "Y" : "N";
                employee.setEmployeeActiveStatus(Boolean.parseBoolean(activeStatus));

                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    // 직원 추가
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (id, name, part, ActiveStatus) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getEmployeeName());
            ps.setString(3, employee.getEmployeePart());
            ps.setString(4, employee.getEmployeeActiveStatus() ? "Y" : "N");
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 직원 수정
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, part = ?, ActiveStatus = ? WHERE id = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmployeePart());
            ps.setString(3, employee.getEmployeeActiveStatus() ? "Y" : "N");
            ps.setInt(4, employee.getEmployeeId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 직원 비활성화
    public boolean deactivateEmployee(int id) {
        String sql = "UPDATE employees SET isDeleted = TRUE WHERE id = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}