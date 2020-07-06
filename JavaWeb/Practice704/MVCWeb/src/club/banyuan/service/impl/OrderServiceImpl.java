package club.banyuan.service.impl;

import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.entity.Order;
import club.banyuan.service.OrderService;
import club.banyuan.util.JdbcUtils;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getOrderbyUserId(int userId) throws Exception {
        OrderDaoImpl orderDao = new OrderDaoImpl(JdbcUtils.getConnection());
        return orderDao.getOrderbyUserId(userId);
    }
}