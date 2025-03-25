package gym.membership.repo;

import gym.membership.domain.Membership;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBConnectionManager;

public class MembershipRepository {

    public List<Membership> findAll() {
        List<Membership> membershipList = new ArrayList<>();
        String sql = "SELECT * FROM memberships";
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                membershipList.add(new Membership(
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
