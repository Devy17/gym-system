package gym.employee.service;

import common.AppUI;
import gym.employee.domain.Employee;
import gym.employee.repo.EmployeeRepository;

import java.util.List;

import static common.AppUI.inputInteger;
import static common.AppUI.inputString;

public class EmployeeService extends AppUI {

    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void start() {
        while (true) {
            employeeMenuScreen();
            int selection = inputInteger(">>> ");

            switch (selection) {
                case 1:
                    getAllEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }

    // 직원 정보 조회
    private void getAllEmployees() {
        try {
            List<Employee> employeeDatabase = employeeRepository.getAllEmployees();
            int employeeCount = employeeDatabase.size();
            if (employeeCount > 0) {
                System.out.printf("\n====== 검색 결과(총 %d건) ======\n", employeeCount);
                for (Employee employee : employeeDatabase) {
                    System.out.println(employee);
                }
            } else {
                System.out.println("\n### 검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("\n### 직원 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 직원 정보 추가
    private void addEmployee() {
        System.out.println("\n====== 직원 정보를 추가합니다. ======");
        int employeeId = inputInteger("# 직원번호: ");
        String employeeName = inputString("# 직원명: ");
        String employeePart = inputString("# 부서명: ");

        Employee employee = new Employee(employeeId, employeeName, employeePart, false);

        employeeRepository.addEmployee(employee);

        System.out.printf("\n### [%s] 정보가 정상적으로 추가되었습니다.\n", employeeName);
    }

    // 직원 정보 수정
    private void updateEmployee() {
        System.out.println("\n====== 직원 정보를 수정합니다. ======");
        String targetName = inputString("# 수정할 직원명: ");

        List<Employee> employeeDatabase = employeeRepository.getAllEmployees();
        if (employeeDatabase == null || employeeDatabase.isEmpty()) {
            System.out.println("\n### 직원 목록이 비어 있습니다.");
            return;
        }

        // 이름으로 직원 검색
        Employee employee = employeeDatabase.stream()
                .filter(e -> e.getEmployeeName().equals(targetName))
                .findFirst()
                .orElse(null);

        if (employee == null) {
            System.out.printf("\n### [%s] 이름을 가진 직원이 없습니다.\n", targetName);
            return;
        }

        System.out.printf("\n### [%s] 직원의 정보를 수정합니다.\n", employee.getEmployeeName());
        int employeeId = inputInteger("# 새로운 직원번호: ");
        String employeeName = inputString("# 새로운 직원명: ");
        String employeePart = inputString("# 새로운 부서명: ");
        boolean employeeActiveStatus = inputInteger("# 활성 상태 (1: 활성, 0: 비활성): ") == 1;

        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeePart(employeePart);
        employee.setEmployeeActiveStatus(employeeActiveStatus);

        employeeRepository.updateEmployee(employee);

        System.out.printf("\n### [%s] 정보가 정상적으로 수정되었습니다.\n", employeeName);
    }

    // 직원 정보 삭제
    public void deleteEmployee() {
        System.out.println("\n====== 직원 정보를 삭제합니다. ======");
        int employeeId = inputInteger("# 삭제할 직원번호: ");

        // 직원 조회 (getEmployeeById 메서드 활용)
        Employee employee = employeeRepository.getAllEmployees(); // 직원 검색 메서드 수정
        if (employee == null) {
            System.out.println("\n### 해당 직원번호로 조회된 직원이 없습니다.");
            return;
        }

        System.out.printf("\n### [%s] 직원 정보를 삭제합니다.\n", employee.getEmployeeId());
        String confirm = inputString("# 정말 삭제하시겠습니까? (Y/N): ");
        if (confirm.equalsIgnoreCase("Y")) {
            boolean success = employeeRepository.deleteEmployee(employeeId); // 삭제 성공 여부 반환
            if (success) {
                System.out.printf("\n### [%s] 직원 정보가 삭제되었습니다.\n", employee.getEmployeeId());
            } else {
                System.out.println("\n### 직원 삭제 중 오류가 발생했습니다.");
            }
        } else {
            System.out.println("\n### 삭제가 취소되었습니다.");
        }
    }
}
