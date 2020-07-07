package club.banyuan.service.impl;

import club.banyuan.dao.IProductDao;
import club.banyuan.dao.impl.IProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> search(String ProName) throws SQLException {
        IProductDao iProductDao = new IProductDaoImpl(JdbcUtils.getConnection());
        return iProductDao.search(ProName);
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        IProductDao iProductDao = new IProductDaoImpl(JdbcUtils.getConnection());
        return iProductDao.getProductById(id);
    }
}
