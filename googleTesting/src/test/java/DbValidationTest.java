import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DbValidationTest {

    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // PostgreSQL 접속 정보
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "password";

        // DB 연결
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to DB successfully.");
    }

    @Test
    public void testUserCount() throws Exception {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM users");

        if (rs.next()) {
            int count = rs.getInt("total");
            System.out.println("Total users: " + count);
            assertTrue(count > 0); // 최소 1명 이상 있어야 함
        }

        rs.close();
        stmt.close();
    }

    @Test
    public void testUserData() throws Exception {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, email FROM users WHERE id = 1");

        if (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");

            assertEquals("John Doe", name);
            assertEquals("john.doe@example.com", email);
        }

        rs.close();
        stmt.close();
    }

    @After
    public void tearDown() throws Exception {
        if (connection != null) connection.close();
        System.out.println("DB connection closed.");
    }
}
