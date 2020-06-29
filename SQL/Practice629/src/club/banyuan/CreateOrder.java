package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class CreateOrder {
    public void newOrder(String userName, Map<String,Product> products) throws SQLException {
        if(!products.containsKey(userName)){
            System.out.println("购物车为空！");
            return;
        }
        Connection conn =JdbcUtils.getConnection(null);
        String sql = "";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,);
        pstmt.setString(2,);

        int count = 0;
        count+=pstmt.executeUpdate(sql);
        if(count==1){
            JdbcUtils.close(conn,pstmt);
            System.out.println("创建订单成功！");
        }else {
            JdbcUtils.close(conn,pstmt);
            System.out.println("创建订单失败！");
        }

    }
}
