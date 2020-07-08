package auction.ss.dao;

import auction.ss.entity.User;

/**
 * @author WM
 * @date 2020/7/8 4:12 下午
 * 描述信息：
 */
public interface IUserDao extends IBaseDao {
    int register(User user);
    User userLogin (String loginName,String password);
}
