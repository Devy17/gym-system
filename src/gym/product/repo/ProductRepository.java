package gym.product.repo;

import gym.product.domain.Product;
import jdbc.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final List<Product> productList = new ArrayList<>();
    public List<Product> findAll() {

        String sql = "SELECT *" +
                "FROM products ";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                productList.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
