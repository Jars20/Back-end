package auction.ss.service.Impl;

import auction.ss.dao.IAdminDao;
import auction.ss.dao.impl.AdminDaoImpl;
import auction.ss.entity.Adminster;
import auction.ss.service.AdminService;
import auction.ss.util.JdbcUtils;

import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 4:41 下午
 * 描述信息：
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public Adminster loginAdmin(String loginName, String pasword) throws SQLException {
        IAdminDao adminDao = new AdminDaoImpl(JdbcUtils.getConnection());
        return adminDao.AdminLogin(loginName,pasword);
    }
}
