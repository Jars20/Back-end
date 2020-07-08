package auction.ss.dao.impl;

import auction.ss.dao.IUserDao;
import auction.ss.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 4:27 下午
 * 描述信息：
 */
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {
    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int register(User user) {
        String sql="insert into User(id,loginName,password,idNum,tel,address,postNUm) values(null,?,?,?,?,?,?)";
        int i = executeInsert(sql,new Object[]{
                user.getLoginName(),
                user.getPassword(),
                user.getIdNum(),
                user.getTel(),user.getAddress(),
                user.getPostNum()
        });
        return i;
    }

    @Override
    public User userLogin(String loginName, String password) {
       String sql = "select * from User where loginName=? and password=?";
       ResultSet rs = executeQuery(sql,new Object[]{loginName,password});
       User user = null;
        try {
            if(rs.next()){
                user = tableToClass(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user= new User(rs.getInt("id"),rs.getString("loginName"),rs.getString("password"),rs.getString("idNum"),rs.getString("tel"),rs.getString("address"),rs.getInt("postNum"));
        if(rs.getString("postNum")!=null){
            user.setPostNum(rs.getInt("postNum"));
        }
        return user;
    }
}
