package club.banyuan.service.Impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/19 10:54 下午
 * 描述信息：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User login(String username, String password) throws SQLException {
        return userDao.getLoginUser(username,password);
    }

    public int registerUser(User user) {
        return userDao.add(user);
    }

    public boolean isExit(String loginName) {
        return (userDao.isExist(loginName)!=null);
    }


}
