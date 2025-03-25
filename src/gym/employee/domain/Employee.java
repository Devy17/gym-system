package gym.employee.domain;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeePart;
    private boolean employeeActiveStatus;

    public Employee() {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePart = employeePart;
        this.employeeActiveStatus = employeeActiveStatus;
    }

    public Employee(int employeeId, String employeeName, String employeePart, boolean employeeActiveStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePart = employeePart;
        this.employeeActiveStatus = employeeActiveStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePart() {
        return employeePart;
    }

    public void setEmployeePart(String employeePart) {
        this.employeePart = employeePart;
    }

    public boolean getEmployeeActiveStatus() {return employeeActiveStatus; };

    public void setEmployeeActiveStatus(boolean employeeActiveStatus) {this.employeeActiveStatus = employeeActiveStatus; };


@Override
public String toString() {
    return "Employee{" +
            "name='" + employeeName + '\'' +
            ", id=" + employeeId +
            ", activeStatus='" + employeeActiveStatus + '\'' +
            '}';
}

}

