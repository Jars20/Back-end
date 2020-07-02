package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IProductDao extends IBaseDao {
    public List<Product> show(String Keyword) throws SQLException;
    public Product getProductById (int ProductId);
}
