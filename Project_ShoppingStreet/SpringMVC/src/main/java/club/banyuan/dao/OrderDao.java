package club.banyuan.dao;

import club.banyuan.entity.Order;

import java.util.List;

public interface OrderDao {
    public Order addOrder(Order order);
    List<Order> getOrderByUserId(Integer userId);
}
