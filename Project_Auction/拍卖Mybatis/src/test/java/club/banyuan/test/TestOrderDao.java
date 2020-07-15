package club.banyuan.test;

import club.banyuan.dao.IOrderDao;
import club.banyuan.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WM
 * @date 2020/7/15 8:35 上午
 * 描述信息：
 */
public class TestOrderDao {
    InputStream ins;
    SqlSession session;
    IOrderDao orderDao;
    @Before
    public void init() throws IOException {
        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(ins);
        session = sqlSessionFactory.openSession();
        orderDao = session.getMapper(IOrderDao.class);
    }

    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }

    @Test
    public void addOrder() {}

    @Test
    public void delOrder() {}

    @Test
    public void selectOrderById() {}

    @Test
    int modifyOrder(Order order){
        Order order1 = new Order();
        order1.setId(null);
        order1.setPrice(2000.0);
        order1.setProductId(1);
        return modifyOrder(order);
    }

}

