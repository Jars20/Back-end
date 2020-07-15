package auction.ss.dao.impl;

import auction.ss.dao.IOrderDao;
import auction.ss.entity.Order;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author WM
 * @date 2020/7/12 11:04 下午
 * 描述信息：
 */
public class OrderDaoImpl extends BaseDaoImpl implements IOrderDao {
    public OrderDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int addOrder(Order order) {
        return 0;
    }

    @Override
    public int delOrder(int i) {
        return 0;
    }

    @Override
    public Order selectOrderById(int id) {
        return null;
    }

    @Override
    public int modifyOrder(Order order) {
        return 0;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
