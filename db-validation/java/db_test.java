import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;

public class DBTest {

    @Test
    public void testOrderStatus() throws Exception {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/testdb",
                "testuser",
                "password"
        );

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT status FROM orders WHERE order_id = 101;");

        if (rs.next()) {
            String status = rs.getString("status");
            assertEquals("COMPLETED", status);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
