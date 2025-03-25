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

    static {
        insertTestData();
    }
    public static void insertTestData() {
        Product product1 = new Product(1, 1, "10회", 50);
        Product product2 = new Product(2, 2, "20회", 100);
        Product product3 = new Product(3, 3, "30회", 150);
        Product product4 = new Product(4, 4, "40회", 200);


        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }


    public List<Product> findAll() {
        String sql = "SELECT *" +
                "FROM products " +
                "JOIN memberships m";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                productList.add(new Product(
                        rs.getInt("product_id"),
                        rs.getInt("membership_id"),
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
