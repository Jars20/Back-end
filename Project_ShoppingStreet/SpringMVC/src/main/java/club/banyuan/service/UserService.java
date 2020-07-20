package club.banyuan.service;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserService {
    User login(String username, String password) throws SQLException;
    int registerUser(User user);
    boolean isExit(String loginName);
}
