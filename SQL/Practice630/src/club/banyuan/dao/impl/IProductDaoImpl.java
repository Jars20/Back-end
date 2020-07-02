package club.banyuan.dao.impl;

import club.banyuan.dao.IProductDao;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IProductDaoImpl extends BaseDaoImpl implements IProductDao {
    public IProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Product> show(String Keyword) throws SQLException {
        String sql = "select * from product where name like ? or description like ?";
        Object[] params = new Object[]{
                "%"+Keyword+"%","%"+Keyword+"%"
        };
        ResultSet rs = executeQuery(sql,params);

        List<Product> productList = new ArrayList<>();
        while(rs.next()){
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setDescription(rs.getString(3));
            product.setPrice(rs.getFloat(4));
            product.setStock(rs.getInt(5));

            productList.add(product);
        }

        return productList;
    }

    @Override
    public Product getProductById(int ProductId) {
        String sql = "select * from product where id = ?";
        Object[] params = new Object[]{
                ProductId};
        ResultSet rs = executeQuery(sql, params);
        Product product = null;
        try {
            if (rs.next()) {
                product = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getInt(5),
                        null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeResource(rs);
        return product;    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
