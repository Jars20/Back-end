package club.banyuan.service;

import club.banyuan.entity.Product;
import club.banyuan.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public List<Product> search(String ProName) throws SQLException;
    Product getProductById(int id) throws SQLException;
}
