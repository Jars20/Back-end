package club.banyuan.dao.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

    public UserDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    //注册
    public int add(User user) {
        String sql = "insert into user(id,loginName,userName,password,sex,email,mobile) values(null,?,?,?,?,?,?)";
        Object[] params = new Object[]{user.getLoginName()
                , user.getUserName(), user.getPassword(), user.getSex(), user.getEmail(), user.getMobile()};
        int i = executeInsert(sql, params);
        closeResource();
        return i;//返回主键值
    }

    @Override
    //登陆
    public User getLoginUser(String loginName, String pwd) {
        String sql = "select * from user where loginName=? and password=?";
        Object[] params = new Object[]{
                loginName, pwd};
        ResultSet rs = executeQuery(sql, params);
        User user = null;
        try {
            if (rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        null, rs.getInt(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeResource(rs);
        return user;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
