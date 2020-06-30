package club.banyuan.dao.impl;

import club.banyuan.dao.IProductDao;
import club.banyuan.entity.Product;

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
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
