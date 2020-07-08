package auction.ss.dao;

import auction.ss.entity.Adminster;

/**
 * @author WM
 * @date 2020/7/8 4:13 下午
 * 描述信息：
 */
public interface IAdminDao extends IBaseDao {
    Adminster AdminLogin(String loginName, String password);
}
