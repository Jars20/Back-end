package club.banyuan.dao;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserDao{
    public int add(User user);
    public User getLoginUser(String loginName, String pwd);
//    public String getDefaultUserAddress(int userId) throws SQLException;
    User isExist(String loginName);
}
