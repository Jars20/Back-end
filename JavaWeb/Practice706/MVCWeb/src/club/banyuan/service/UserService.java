package club.banyuan.service;

import club.banyuan.entity.User;

import java.sql.SQLException;

public interface UserService {
    public User login(String username, String password) throws SQLException;
    public int register(String l_user,String l_pwd,String l_email,String l_tel,String l_mem,String l_num) throws SQLException;
}
