package auction.ss.service;

import auction.ss.entity.User;

import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 4:43 下午
 * 描述信息：
 */
public interface UserService {
    int register(String loginName,String userName,String password,String idNum,String tel,String address,Integer postNum) throws SQLException;
    User loginName(String loginName,String password) throws SQLException;
}
