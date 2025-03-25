package gym.employee.service;

import gym.employee.domain.Employee;
import gym.employee.repo.EmployeeRepository;
import java.util.List;
import java.util.Random;

public class EmployeeService {

    EmployeeRepository employeeRepository = new EmployeeRepository();

    public int getRandomEmployeeId() {
        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList == null || employeeList.isEmpty()) {
            return -1;
        }

        // 랜덤으로 직원 선택
        Random random = new Random();
        int randomIndex = random.nextInt(employeeList.size());
        Employee selectedEmployee = employeeList.get(randomIndex);

        return selectedEmployee.getEmployeeId();
    }

}
