package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    // 오라클 JDBC 연결 정보
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "shin"; // 본인 계정
    private static final String PASSWORD = "shin"; // 본인 비밀번호

    // 정적 초기화자를 사용하여 드라이버를 로드
    static {
        try {
            Class.forName(DRIVER);
//            System.out.println("JDBC 드라이버 강제 구동 완료!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패.");
            e.printStackTrace();
        }
    }

    // 데이터베이스 접속 객체를 리턴해주는 메서드
    // 데이터베이스 접속 객체 Connection을 리턴, 예외를 던짐
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
