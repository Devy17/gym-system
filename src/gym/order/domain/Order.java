package gym.order.domain;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private int userId;
    private int membershipId;
    private int productId;
    private LocalDate orderDate;

    public Order(int orderId, int userId, int membershipId, int productId, LocalDate orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.membershipId = membershipId;
        this.productId = productId;
        this.orderDate = orderDate;
    }

    public Order(int orderId, int userId, int membershipId, int productId) {
        this.orderId = orderId;
        this.userId = userId;
        this.membershipId = membershipId;
        this.productId = productId;
        this.orderDate = LocalDate.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
