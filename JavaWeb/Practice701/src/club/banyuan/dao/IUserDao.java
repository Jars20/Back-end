package club.banyuan.dao;

import club.banyuan.enity.User;

public interface IUserDao extends IBaseDao {
  public int add(User user);
  public User getLoginUser(String loginName,String password);
}
