package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDAO {
    public Connection connectDB(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/aula_crud?user=root";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
        return conn;
    }
}
