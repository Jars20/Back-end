package club.banyuan.dao;

import club.banyuan.entity.Order;
import java.util.List;

public interface OrderDao extends IBaseDao{
    List<Order> getOrderbyUserId(int userId)throws Exception;
}
