package gym.product.repo;

import gym.membership.domain.Membership;
import gym.product.domain.Product;
import jdbc.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT " +

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                productList.add(new Membership(
                        rs.getInt("price"),
                        rs.getInt("period"),
                        rs.getInt("membership_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membershipList;
    }
}
