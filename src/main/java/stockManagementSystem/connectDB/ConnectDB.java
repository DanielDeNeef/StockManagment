package stockManagementSystem.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StockManagement", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
