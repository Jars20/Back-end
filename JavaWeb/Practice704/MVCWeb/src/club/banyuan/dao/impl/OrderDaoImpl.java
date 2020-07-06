package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

    public OrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Order> getOrderbyUserId(int userId) throws Exception {
        String sql = "select * from `order` where userId=?";
        ResultSet resultSet = null;
        List<Order> orderList = new ArrayList<>();
        resultSet = executeQuery(sql,new Integer[]{userId});
        while (resultSet.next()){
            orderList.add(tableToClass(resultSet));
        }
        return orderList;
    }

    @Override
    public Order tableToClass(ResultSet rs) throws Exception {
        return new Order(rs.getInt("id"),
                rs.getInt("userId"),
                rs.getString("loginName"),
                rs.getString("userAddress"),
                new java.util.Date(rs.getDate("createTime").getTime()),
                rs.getDouble("cost"),
                rs.getString("serialNumber")
        );
    }
}