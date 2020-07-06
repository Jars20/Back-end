package club.banyuan.dao;

import club.banyuan.entity.Product;

import java.util.List;

public interface IProductDao extends IBaseDao {
    List<Product> search(String ProName);
    Product getProductById (int id);
}
