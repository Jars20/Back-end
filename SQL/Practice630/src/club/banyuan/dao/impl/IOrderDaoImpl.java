package club.banyuan.dao.impl;

import club.banyuan.dao.IOrderDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class IOrderDaoImpl extends BaseDaoImpl implements IOrderDao {

    public IOrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int addOrder(Order order) {
        String sql = "insert into order(id,userId,loginName,userAddress,createTime,cost) values(null,?,?,?,?,?)";
        Object[] params = new Object[]{
                order.getUserId(),
                order.getLoginName(),
                order.getUserAddress(),
                new java.sql.Date(order.getCreateTime().getTime()),
                order.getCost()
        };
        int i = executeInsert(sql, params);
        closeResource();
        return i;//返回主键值
    }

    @Override
    public Order show(String loginName) throws SQLException {
        String sql = "select * from order where loginName = ?";
        Object[] param = new Object[]{
                loginName
        };
        ResultSet rs = executeQuery(sql,param);
        Order order = null;
        if (rs.next()){
            order.setUserId(rs.getInt(1));
            order.setLoginName(rs.getString(2));
            order.setUserAddress(rs.getString(3));
            order.setCreateTime(rs.getDate(4));
            order.setUserAddress(rs.getString(5));
        }
        closeResource(rs);
        return order;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
