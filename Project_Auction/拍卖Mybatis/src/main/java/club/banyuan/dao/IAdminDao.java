package club.banyuan.dao;


import club.banyuan.entity.Adminster;

import java.util.Map;

/**
 * @author WM
 * @date 2020/7/8 4:13 下午
 * 描述信息：
 */
public interface IAdminDao {
    Adminster AdminLogin(Map map);
}
