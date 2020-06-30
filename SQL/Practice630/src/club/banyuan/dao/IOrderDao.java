package club.banyuan.dao;

import club.banyuan.entity.Order;

import java.sql.SQLException;

public interface IOrderDao extends IBaseDao{
    public int addOrder(Order order);
    public Order show(String loginName) throws SQLException;
}
