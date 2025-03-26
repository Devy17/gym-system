package gym.employee.domain;

public class Employee {

    private int employee_Id;
    private String employee_Name;
    private String Part;
    private boolean employee_Active;

    public Employee() {
        this.employee_Id = employee_Id;
        this.employee_Name = employee_Name;
        this.Part = Part;
        this.employee_Active = employee_Active;
    }

    public Employee(int employeeId, String employeeName, String part, boolean employeeActive) {
        this.employee_Id = employeeId;
        this.employee_Name = employeeName;
        this.Part = part;
        this.employee_Active = employeeActive;
    }

    public int getEmployeeId() {
        return employee_Id;
    }

    public void setEmployeeId(int employeeId) {
        this.employee_Id = employeeId;
    }

    public String getEmployeeName() {
        return employee_Name;
    }

    public void setEmployeeName(String employeeName) {
        this.employee_Name = employeeName;
    }

    public String getPart() {
        return Part;
    }

    public void setPart(String Part) {
        this.Part = Part;
    }

    public boolean getEmployeeActive() {
        return employee_Active;
    }

    public void setEmployeeActive(boolean employeeActive) {
        this.employee_Active = employee_Active;
    }


    @Override
    public String toString() {
        return "Employee {\n" +
                "    name: '" + employee_Name + "',\n" +
                "    id: " + employee_Id + ",\n" +
                "    active: '" + (employee_Active ? "Y" : "N") + "'\n" +
                "}";
    }


}

;




