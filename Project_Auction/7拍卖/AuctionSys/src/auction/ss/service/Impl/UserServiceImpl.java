package auction.ss.service.Impl;

import auction.ss.dao.IUserDao;
import auction.ss.dao.impl.UserDaoImpl;
import auction.ss.entity.User;
import auction.ss.service.UserService;
import auction.ss.util.JdbcUtils;

import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 4:47 下午
 * 描述信息：
 */
public class UserServiceImpl implements UserService {
    @Override
    public int register(String loginName, String userName, String password, String idNum, String tel, String address, Integer postNum) throws SQLException {
        User user = new User(null,loginName,userName,password,idNum,tel,address,postNum);
        IUserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        return userDao.register(user);
    }

    @Override
    public User loginName(String loginName, String password) throws SQLException {
        IUserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        return userDao.userLogin(loginName, password);
    }
}
