package club.banyuan.dao;

import club.banyuan.entity.Order_Detail;

import java.sql.SQLException;

public interface IOrderDetailDao extends IBaseDao {
    public int addOrderDetail(Order_Detail order_detail);
    public Order_Detail show(int orderId) throws SQLException;

}
