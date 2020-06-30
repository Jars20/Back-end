package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.util.JdbcUtils;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class CreateOrder {
    public Order newOrder(String userName, HashMap<String, ArrayList<Product>> products) throws SQLException {
        if (!products.containsKey(userName)) {
            System.out.println("购物车为空！");
            return null;
        }
        Connection conn = JdbcUtils.getConnection(null);
        String sql = null;
        PreparedStatement pstmt = null;

        double cost = 0;
        for (int i = 0; i < products.get(userName).size(); i++) {
            Product temp = products.get(userName).get(i);
            cost += temp.getPrice() * temp.getQuantity();
        }

        Order order = new Order();
        order.setCost(cost);
        order.setCreateTime(new Date());

        String orderSql = "insert into shoppingstreet.order(id,userId,cost,createTime) values(null,?,?,?)" ;
        PreparedStatement pstm2 = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
        pstm2.setInt(1,order.getUserId());
        pstm2.setDouble(2,order.getCost());
        pstm2.setDate(3,new java.sql.Date(order.getCreateTime().getTime()));
        int count =pstm2.executeUpdate();

        ResultSet rs = pstm2.getGeneratedKeys();

        if(rs.next()){
            order.setId((int)rs.getLong(1));
        }

        if (count > 0) {
            JdbcUtils.close(conn, pstmt);
            System.out.println("创建订单成功！");
        } else {
            JdbcUtils.close(conn, pstmt);
            System.out.println("创建订单失败！");
        }

        return order;
    }
}
