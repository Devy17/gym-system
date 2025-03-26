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
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setPart(rs.getString("part"));

                // "Y" 또는 "N" 값을 boolean으로 변환
                String active = rs.getString("employee_active");
                boolean isActive = "Y".equalsIgnoreCase(active);
                employee.setEmployeeActive(isActive);

                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    // 직원 추가
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (employee_id, employee_name, part, employee_active) VALUES (employees_seq.NEXTVAL, ?, ?, ?)";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getPart());
            ps.setString(3, "Y"); // Active 상태를 항상 "Y"로 설정

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 직원 수정
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET employee_name = ?, part = ?, employee_active = ? WHERE employee_id = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getPart());
            ps.setBoolean(3, Boolean.parseBoolean(employee.getEmployeeActive() ? "Y" : "N"));
            ps.setInt(4, employee.getEmployeeId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 직원 비활성화
    public boolean deactivateEmployee(int id) {
        String sql = "UPDATE employees SET employee_active = 'N' WHERE employee_id = ?";
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