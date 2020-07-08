package auction.ss.service;

import auction.ss.entity.Adminster;

import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 4:16 下午
 * 描述信息：
 */
public interface AdminService {
    Adminster loginAdmin (String loginName,String pasword) throws SQLException;
}
