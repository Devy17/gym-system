package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    // 오라클 JDBC 연결 정보
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // 정해져있는 값
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스에 요청을 보내는 주소 -> 접속
    private static final String USER = "shin"; // TODO 작성해주세요
    private static final String PASSWORD = "shin"; // TODO 작성해주세요

    // 정적 초기화자(static initializer)를 사용하여 드라이버 로드
    static {
        try {
            Class.forName(DRIVER); // 객체를 생성하지 않고 클래스를 강제 구동
            System.out.println("JDBC 드라이버 강제 구동 완료!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패!");
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
