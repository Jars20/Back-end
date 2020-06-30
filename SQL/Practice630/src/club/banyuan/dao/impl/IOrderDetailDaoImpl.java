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
        return i;//返回主键值
    }

    @Override
    public Order_Detail show(String loginName) throws SQLException {
        String sql = "select * from order_detail where loginName = ?";
        Object[] param = new Object[]{
                loginName
        };
        ResultSet rs = executeQuery(sql,param);
        Order_Detail od = null;
        while(rs.next()){
            od.setOrderId(rs.getInt(1));
            od.setProductId(rs.getInt(2));
            od.setQuantity(rs.getInt(3));
            od.setCost(rs.getFloat(4));
        }
        closeResource(rs);
        return od;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
