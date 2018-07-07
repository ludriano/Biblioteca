/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LUDRIANO
 */
public class ConnectionFactory {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static String USER = "root";
    private static String PASS = "1234";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexao: " + e);
        }

    }

    public static void closeConnection(Connection conn) {

        try {

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

            throw new RuntimeException("Erro na conexao: " + e);

        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) {

        closeConnection(conn);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {

            throw new RuntimeException("Erro na conexao: " + e);

        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {

        closeConnection(conn, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {

            throw new RuntimeException("Erro na conexao: " + e);

        }
    }
}
