package auction.ss.dao.impl;

import auction.ss.dao.IProductDao;
import auction.ss.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WM
 * @date 2020/7/9 5:08 下午
 * 描述信息：
 */
public class ProductDaoImpl extends BaseDaoImpl implements IProductDao {
    public ProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Product tableToClass(ResultSet rs) throws Exception {
//        System.out.println("TableToClass时的startTIme：" + new Timestamp(rs.getDate("startTime").getTime()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Product product = new Product(
                rs.getInt("id"),
                rs.getString("name"),
                null,
                rs.getDouble("lowPrice"),
                rs.getDouble("basePrice"),
                format.format(rs.getTimestamp("startTime")),
                format.format(rs.getTimestamp("finalTime")),
                rs.getDouble("highPriceTemp"),
                rs.getInt("onSell"),
                rs.getInt("soldOrNot")
        );
        if (rs.getString("description") != null) {
            product.setDescription(rs.getString("description"));
        }
        return product;

    }


    @Override
    public int addProduct(Product product) throws ParseException {
        String sql = "insert into Product values(null,?,?,?,?,?,?,?,?,?)";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("新增的product： "+product );

        int i = executeInsert(sql, new Object[]{
                product.getName(),
                product.getDescription(),
                product.getLowPrice(),
                product.getBasePrice(),
                format.parse(product.getStartTime()),
                format.parse(product.getFinalTime()),
                product.getHighPriceTemp(),
                1,
                0
        });
        return i;
    }

    @Override
    public int deleteProduct(int id) throws ParseException {
        String sql = "delete from Product where id = ?";

        int i = executeUpdate(sql, new Object[]{id});
        return i;
    }

    @Override
    public int sellProduct(int id) {
        String sql = "update Product set onSell=0,soldOrNot=1 where id =?";
        return executeUpdate(sql, new Object[]{
                id
        });
    }

    @Override
    public int passProduct(int id) {
        String sql = "update Product set onSell=0,soldOrNot=0 where id =?";
        return executeUpdate(sql, new Object[]{
                id
        });
    }

    @Override
    public int renewPrice(Double price, int id) {
        String sql = "update Product highPriceTemp=? where id =?";
        return executeUpdate(sql, new Object[]{
                price, id
        });
    }

    @Override
    public int renewProduct(Product product) throws ParseException {
        String sql = "update Product set name=?,description =?,lowPrice =?,basePrice =?,startTime=?,finalTime =? where id=?";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

        System.out.println("更新后的product数据 "+product);

        int i = executeUpdate(sql, new Object[]{
                product.getName(),
                product.getDescription(),
                product.getLowPrice(),
                product.getBasePrice(),
                format.parse(product.getStartTime()),
                format.parse(product.getFinalTime()),
                product.getId()
        });
        return i;
    }

    @Override
    public Product selectById(int id) {
        String sql = "select * from Product where id=?";
        ResultSet rs = executeQuery(sql, new Object[]{id});
        Product product = null;
        try {
            if (rs.next()) {
                product = tableToClass(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    //baseprice为起拍价
    public List<Product> showProduct(String name, String description, String startTime, String finalTime, Double basePrice) {
        String sql = "select * from Product " +
                "where name = if(? is null, name , ?) " +
                "and description = if(? is null, description,?)" +
                "and startTime = if(? is null, startTime, ?)" +
                "and finalTime = if(? is null, finalTime,?)" +
                "and basePrice = if(? is null, basePrice, ?)" +
                "and onSell =1 and soldOrNot = 0";
        ResultSet rs = executeQuery(sql, new Object[]{
                name, name,
                description, description,
                startTime, startTime,
                finalTime, finalTime,
                basePrice, basePrice
        });
        List<Product> productList = new ArrayList<>();
        Product product = null;
        try {
            while (rs.next()) {
                product = tableToClass(rs);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}
