package gym.user.repo;

import gym.user.domain.User;
import jdbc.DBConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public void addUser(User user) {
        String sql = "INSERT INTO users VALUES(user_seq.NEXTVAL, ?, ?, ?, ?)\";";

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

    public void updateUserActive(User user, boolean b) {
        String sql = "UPDATE users SET user_active = ? WHERE user_id = ?";
        try(Connection conn = DBConnectionManager.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, b ? "Y" : "N");
            pstmt.setInt(2, user.getUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
