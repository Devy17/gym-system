package gym.product.repo;

import gym.product.domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.DBConnectionManager;

public class ProductRepository {

    /**
     * 상품 추가
     */
    public void addProduct(Product product) {
        String sql = "INSERT INTO products VALUES(memberships_seq.NEXTVAL ,? ,?)";

        try (Connection conn = DBConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setInt(2, product.getPrice());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
