package auction.ss.dao.impl;

import auction.ss.dao.IAdminDao;
import auction.ss.entity.Adminster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 4:14 下午
 * 描述信息：
 */
public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao {
    public AdminDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Adminster AdminLogin(String loginName, String password) {
        String sql ="select * from Administer where loginName=? and password =?";
        ResultSet rs = executeQuery(sql,new Object[]{loginName,password});
        Adminster adminster =null;
        try {
            if(rs.next()){
                adminster = tableToClass(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminster;
    }

    @Override
    public Adminster tableToClass(ResultSet rs) throws Exception {
        return new Adminster(
                rs.getInt("id"),
                rs.getString("loginName"),
                rs.getString("userName"),
                rs.getString("password"));
    }
}
