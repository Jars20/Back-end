package club.banyuan.dao;


import club.banyuan.entity.User;

/**
 * @author WM
 * @date 2020/7/8 4:12 下午
 * 描述信息：
 */
public interface IUserDao {
    int register(User user);
    User userLogin(String loginName, String password);

}
