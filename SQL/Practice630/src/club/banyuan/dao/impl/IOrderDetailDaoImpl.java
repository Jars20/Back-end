package club.banyuan.dao.impl;

import club.banyuan.dao.IOrderDetailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.Order_Detail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IOrderDetailDaoImpl extends BaseDaoImpl implements IOrderDetailDao {
    public IOrderDetailDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int addOrderDetail(Order_Detail order_detail) {
        String sql = "insert into order_detail(orderId,productId,quantity,cost) values(?,?,?,?)";
        Object[] params = new Object[]{
                order_detail.getOrderId(),
                order_detail.getProductId(),
                order_detail.getQuantity(),
                order_detail.getCost()
        };
        int i = executeInsert(sql, params);
        closeResource();
        return i;//返回主键值
    }

    @Override
    public Order_Detail show(int orderId) throws SQLException {
        String sql = "select * from order_detail where orderId = ?";
        Object[] param = new Object[]{
                orderId
        };
        ResultSet rs = executeQuery(sql,param);
        Order_Detail od = new Order_Detail();
        while(rs.next()){
            od.setId(rs.getInt(1));
            od.setOrderId(orderId);
            od.setProductId(rs.getInt(3));
            od.setQuantity(rs.getInt(4));
            od.setCost(rs.getFloat(5));
        }
        closeResource(rs);
        return od;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
