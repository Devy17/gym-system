package gym.employee.service;

// 수정된 EmployeeService.java
import common.AppUI;
import gym.employee.domain.Employee;
import gym.employee.repo.EmployeeRepository;

import java.util.List;

public class EmployeeService extends AppUI {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    // 직원 정보 조회
    public void getAllEmployees() {
        try {
            List<Employee> employeeDatabase = employeeRepository.getAllEmployees();
            if (employeeDatabase == null || employeeDatabase.isEmpty()) {
                System.out.println("\n### 검색 결과가 없습니다.");
                return;
            }
            System.out.printf("\n====== 검색 결과(총 %d건) ======\n", employeeDatabase.size());
            employeeDatabase.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("\n### 직원 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 직원 정보 추가
    public void addEmployee() {
        System.out.println("\n====== 직원 정보를 추가합니다. ======");
        int employeeId = inputInteger("# 직원번호: ");
        String employeeName = inputString("# 직원명: ");
        String employeePart = inputString("# 부서명: ");

        Employee employee = new Employee(employeeId, employeeName, employeePart, false);

        employeeRepository.addEmployee(employee);

        System.out.printf("\n### [%s] 정보가 정상적으로 추가되었습니다.\n", employeeName);
    }

    // 직원 정보 수정
    public void updateEmployee() {
        System.out.println("\n====== 직원 정보를 수정합니다. ======");
        String targetName = inputString("# 수정할 직원명: ");

        try {
            List<Employee> employeeDatabase = employeeRepository.getAllEmployees();
            if (employeeDatabase == null || employeeDatabase.isEmpty()) {
                System.out.println("\n### 직원 목록이 비어 있습니다.");
                return;
            }

            Employee employee = employeeDatabase.stream()
                    .filter(e -> e.getEmployeeName().equals(targetName))
                    .findFirst()
                    .orElse(null);

            if (employee == null) {
                System.out.printf("\n### [%s] 이름을 가진 직원이 없습니다.\n", targetName);
                return;
            }

            System.out.printf("\n### [%s] 직원의 정보를 수정합니다.\n", employee.getEmployeeId());
            employee.setEmployeeId(inputInteger("# 새로운 직원번호: "));
            employee.setEmployeeName(inputString("# 새로운 직원명: "));
            employee.setEmployeePart(inputString("# 새로운 부서명: "));
            employee.setEmployeeActiveStatus(inputInteger("# 활성 상태 (1: 활성, 0: 비활성): ") == 1);

            employeeRepository.updateEmployee(employee);
            System.out.printf("\n### [%s] 정보가 정상적으로 수정되었습니다.\n", employee.getEmployeeName());
        } catch (Exception e) {
            System.out.println("\n### 직원 수정 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 직원 정보 삭제
    public void deleteEmployee() {
        System.out.println("\n====== 직원 정보를 삭제합니다. ======");
        String targetName = inputString("# 삭제할 직원명: ");

        try {
            Employee employee = findEmployeeByName(targetName);
            if (employee == null) {
                System.out.println("\n### 해당 직원명으로 조회된 직원이 없습니다.");
                return;
            }

            System.out.printf("\n### [%s] 직원 정보를 삭제합니다.\n", employee.getEmployeeName());
            String confirm = inputString("# 정말 삭제하시겠습니까? (Y/N): ");
            if (confirm.equalsIgnoreCase("Y")) {
                employeeRepository.deactivateEmployee(employee.getEmployeeId());
                System.out.printf("\n### [%s] 직원 정보가 삭제되었습니다.\n", employee.getEmployeeName());
            } else {
                System.out.println("\n### 삭제가 취소되었습니다.");
            }
        } catch (Exception e) {
            System.out.println("\n### 직원 삭제 중 오류가 발생했습니다: " + e.getMessage());

        }
    }

    // 이름으로 직원 검색 (재사용 가능)
    private Employee findEmployeeByName(String employeeName) {
        List<Employee> employees = employeeRepository.getAllEmployees();
        if (employees == null || employees.isEmpty()) return null;

        return employees.stream()
                .filter(e -> e.getEmployeeName().equals(employeeName))
                .findFirst()
                .orElse(null);
    }
}