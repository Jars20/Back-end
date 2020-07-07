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
    public List<Product> search(String ProName) {
        String sql = "select * from product where name like ? or description like ?";
        ResultSet rs = executeQuery(sql, new Object[]{"%"+ProName+"%", "%"+ProName+"%"});

        List<Product> productList = new ArrayList<>();
        try {
            while (rs.next()) {
                productList.add(tableToClass(rs));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        String sql =" select * from product where id = ?";
        ResultSet rs = executeQuery(sql,new Object[]{id});
        try {
            if (rs.next()){
                return tableToClass(rs);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Product tableToClass(ResultSet rs) throws Exception {
        Product product = new Product(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getFloat(4),
                rs.getInt(5));
        return product;
    }
}
