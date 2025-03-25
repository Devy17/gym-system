package gym.access.domain;

import java.time.LocalDate;

public class Access {
    private int accessId;
    private int userId;
    private int productId;
    private LocalDate accessDate;

    public Access(int accessId, int userId, int productId, LocalDate accessDate) {
        this.accessId = accessId;
        this.userId = userId;
        this.productId = productId;
        this.accessDate = accessDate;
    }

    public Access(int accessId, int userId, int productId) {
        this.accessId = accessId;
        this.userId = userId;
        this.productId = productId;
        this.accessDate = LocalDate.now();
    }


    public int getAccessId() {
        return accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDate getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(LocalDate accessDate) {
        this.accessDate = accessDate;
    }
}
