package club.banyuan.util;

import java.sql.*;

public class JdbcUtils {
    private static String USER = "root";
    private static String PWD = "12345678";
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String DB = "shoppingstreet";

    public static Connection getConnection(String dbName) throws SQLException {
        String url =URL+DB;
        if(dbName!=null&&dbName!=""){
            url = URL+dbName;
        }
        Connection conn = DriverManager.getConnection(url,USER,PWD);
        return conn;
    }

    public static void close(Connection conn,Statement stmt) throws SQLException {
        if (stmt!=null){
            stmt.close();
        }
        if(conn!=null){
            conn.close();
        }
    }


    public static void close(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
        close(conn,stmt);
        if(rs!=null){
            rs.close();
        }
    }

}
