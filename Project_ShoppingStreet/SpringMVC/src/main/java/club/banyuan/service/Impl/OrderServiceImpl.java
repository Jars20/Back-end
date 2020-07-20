package club.banyuan.service.Impl;


import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WM
 * @date 2020/7/18 3:26 下午
 * 描述信息：
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public void createOrder(Order order, List<OrderDetail> orderDetailList) throws Exception {
        orderDao.addOrder(order);

    }
}
