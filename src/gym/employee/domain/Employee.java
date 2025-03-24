package gym.employee.domain;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String part;
    private boolean employeeActive;

    public Employee(int employeeId, String employeeName, String part, boolean employeeActive) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.part = part;
        this.employeeActive = employeeActive;
    }

    public Employee(int employeeId, String employeeName, String part) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.part = part;
        this.employeeActive = true;
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

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public boolean isEmployeeActive() {
        return employeeActive;
    }

    public void setEmployeeActive(boolean employeeActive) {
        this.employeeActive = employeeActive;
    }
}
