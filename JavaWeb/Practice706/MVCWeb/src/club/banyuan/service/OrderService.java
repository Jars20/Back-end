package club.banyuan.service;

import club.banyuan.entity.Order;
import java.util.List;

public interface OrderService {
    List<Order> getOrderbyUserId(int userId) throws Exception;
}