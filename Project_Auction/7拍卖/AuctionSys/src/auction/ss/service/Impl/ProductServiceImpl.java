package auction.ss.service.Impl;

import auction.ss.dao.IProductDao;
import auction.ss.dao.impl.ProductDaoImpl;
import auction.ss.entity.Product;
import auction.ss.service.ProductService;
import auction.ss.util.JdbcUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author WM
 * @date 2020/7/9 8:12 下午
 * 描述信息：
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> showProduct(String name, String description, String startTime, String finalTime, Double basePrice) throws SQLException {
        IProductDao productDao = new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.showProduct(name, description, startTime, finalTime, basePrice);
    }

    @Override
    public int addProduct(Product product) throws ParseException, SQLException {
        IProductDao productDao = new ProductDaoImpl(JdbcUtils.getConnection());
        int i = productDao.addProduct(product);
        return i;
    }

    @Override
    public int renewProduct(Product product) throws SQLException, ParseException {
        IProductDao productDao =new ProductDaoImpl(JdbcUtils.getConnection());
        int i = productDao.renewProduct(product);
        return i;
    }

    @Override
    public Product select(int id) throws SQLException {
        IProductDao productDao = new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.selectById(id);
    }

    @Override
    public int delProduct(int id) throws SQLException, ParseException {
        IProductDao productDao = new ProductDaoImpl(JdbcUtils.getConnection());
        return productDao.deleteProduct(id);
    }
}
