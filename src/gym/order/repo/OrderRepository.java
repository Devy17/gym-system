package gym.order.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.DBConnectionManager;

public class OrderRepository {

    public boolean insertOrder(int userId, int membershipId, int employeeId) {
        String query =
                "INSERT INTO orders (order_id, user_id, membership_id, order_date, employee_id) " +
                        "VALUES (orders_seq.NEXTVAL, ?, ?, SYSDATE, ?)";

        try (Connection conn = DBConnectionManager.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, membershipId);
            pstmt.setInt(3, employeeId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
