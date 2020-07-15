package auction.ss.dao;

import auction.ss.entity.Order;

/**
 * @author WM
 * @date 2020/7/12 10:46 下午
 * 描述信息：
 */
public interface IOrderDao extends IBaseDao {
    int addOrder(Order order);
    int delOrder(int i);
    Order selectOrderById(int id);
    int modifyOrder(Order order);
}
