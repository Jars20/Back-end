package club.banyuan.test;

import club.banyuan.dao.IAdminDao;
import club.banyuan.entity.Adminster;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WM
 * @date 2020/7/14 8:58 上午
 * 描述信息：
 */
public class TestAdminDao {
    InputStream ins;
    SqlSession session;
    IAdminDao adminDao;
    @Before
    public void init() throws IOException {
        // 加载配置文件
        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获取用于创建SqlSessionFactory对象的类的对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = builder.build(ins);
        // 创建SqlSession对象
        session = sqlSessionFactory.openSession();
        // 获取接口的实现类对象
        // 动态代理设计模式，获取接口的实现类对象
        adminDao = session.getMapper(IAdminDao.class);
    }

    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }

    @Test
    public void testAdminLogin() {
        Map<String,String> map = new HashMap<String, String>();
        map.put("loginName","kkkk");
        map.put("password","123");

        Adminster adminster = adminDao.AdminLogin(map);
        System.out.println(adminster);
    }
}
