package gym.membership.domain;

import java.time.LocalDate;

public class Membership {
    private int membershipId;
    private int employeeId;
    private LocalDate period;
    private int price;


    public Membership(int price, LocalDate period, int employeeId, int membershipId) {
        this.price = price;
        this.period = period;
        this.employeeId = employeeId;
        this.membershipId = membershipId;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
