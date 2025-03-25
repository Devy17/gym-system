package gym.user.repo;

import gym.user.domain.User;
import jdbc.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public void addUser(User user) {
        String sql = "INSERT INTO users VALUES(users_seq.NEXTVAL, ?, ?, ?, ?)";

        try(Connection conn = DBConnectionManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setDate(3, Date.valueOf(user.getRegistDate()));
            pstmt.setString(4, user.isUserActive() ? "Y" : "N");

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Activation() { //회원 활성화 여부
        String userUpdateSql = "UPDATE users u JOIN status s ON u.user_id = s.user_id " +
                "SET u.user_active = 'N' " +
                "WHERE s.product_count = 0 AND s.remained_month = 0";

        String statusUpdateSql = "UPDATE status SET last_updated = CURRENT_TIMESTAMP " +
                "WHERE product_count = 0 AND remained_month = 0";

        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement userPstmt = conn.prepareStatement(userUpdateSql);
             PreparedStatement statusPstmt = conn.prepareStatement(statusUpdateSql)) {

            // 유저 테이블
            userPstmt.executeUpdate();

            // 상태 테이블
            statusPstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public List<User> findByUserName(String name) {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE user_name = ? AND user_active = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, "Y");

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                userList.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("phone_number"),
                        rs.getDate("regist_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void updateUserInfo(User user) {
        String sql = "UPDATE users SET user_name = ?, phone_number = ? WHERE user_id = ?";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setInt(3, user.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
