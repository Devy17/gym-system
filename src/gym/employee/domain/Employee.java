package gym.employee.domain;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String Part;
    private boolean employeeActive;

    public Employee() {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.Part = Part;
        this.employeeActive = employeeActive;
    }

    public Employee(int employeeId, String employeeName, String part, boolean employeeActive) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.Part = part;
        this.employeeActive = employeeActive;
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
        return Part;
    }

    public void setPart(String Part) {
        this.Part = Part;
    }

    public boolean getEmployeeActive() {
        return employeeActive;
    }

    ;

    public void setEmployeeActive(boolean employeeActive) {
        this.employeeActive = employeeActive;
    }

    ;


    @Override
    public String toString() {
        return "Employee {\n" +
                "    name: '" + employeeName + "',\n" +
                "    id: " + employeeId + ",\n" +
                "    active: '" + employeeActive + "'\n" +
                "}";
    }
}

