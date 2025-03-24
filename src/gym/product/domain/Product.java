package gym.product.domain;

public class Product {
    private int productId;
    private int employeeId;
    private int membershipId;
    private String productName;
    private int price;

    public Product(int productId, int employeeId, int membershipId, String productName, int price) {
        this.productId = productId;
        this.employeeId = employeeId;
        this.membershipId = membershipId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
