package club.banyuan;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SelectProducts {
    public Map<String,Product> products = new HashMap<>();
    public void searchSystem (String userName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的关键字：\n");
        String keyName= sc.nextLine();

        try {
            search(keyName,userName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void search(String keyName,String userName) throws SQLException {
        Connection conn =JdbcUtils.getConnection(null);
        String sql = "select * from product where name like ? or description like ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"%"+keyName+"%");
        pstmt.setString(2,"%"+keyName+"%");

        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
           Product product = new Product();
           product.setId(rs.getInt("id"));
           product.setName(rs.getString("name"));
           product.setDescription(rs.getString("description"));
           product.setPrice(rs.getFloat("price"));
           product.setStock(rs.getInt("stock"));

           products.put(userName,product);
        }

        JdbcUtils.close(conn,pstmt,rs);
    }
}
