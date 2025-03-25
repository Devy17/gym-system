package gym.employee.repo;

import gym.employee.domain.Employee;
import jdbc.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static final List<Employee> employeeDatabase = new ArrayList<>();

    static{
       employeeData();
    }
    // 직원 정보 삽입
    private static void employeeData() {
        Employee employee1 = new Employee(1, "강하늘", "FC", true);
        Employee employee2 = new Employee(1, "구현희", "FC", true);
        Employee employee3 = new Employee(1, "송병준", "PT", true);
        Employee employee4 = new Employee(1, "신현국", "PT",true);
        Employee employee5 = new Employee(1, "전유빈", "PT", true);

        employeeDatabase.add(employee1);
        employeeDatabase.add(employee2);
        employeeDatabase.add(employee3);
        employeeDatabase.add(employee4);
        employeeDatabase.add(employee5);

    }


    // 직원 추가
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (id, name, part, ActiveStauts) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getEmployeeName());
            ps.setString(3, employee.getEmployeePart());
            ps.setBoolean(4, employee.getEmployeeActiveStatus());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 직원 수정
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, part = ?, acetivestatus = ? WHERE id = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmployeePart());
            ps.setInt(3, employee.getEmployeeId());
            ps.setBoolean(4, employee.getEmployeeActiveStatus());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 직원 삭제
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

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
                employee.setEmployeeActiveStatus(rs.getBoolean("employeeActive"));
                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }


}