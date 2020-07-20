package club.banyuan.dao;

import club.banyuan.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    public OrderDetail addOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getOrderDetailByOrderId(Integer id);
}
