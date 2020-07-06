package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) throws SQLException {
        UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        return userDao.getLoginUser(username, password);
    }

    @Override
    public int register(String l_user, String l_pwd, String l_email, String l_tel, String l_mem, String l_num) throws SQLException {
        User user = new User(
                null,
                l_tel,
                l_user,
                l_pwd,
                0,
                l_email,
                l_tel);
//        System.out.println(user);
        UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
        return userDao.add(user);
    }
}
