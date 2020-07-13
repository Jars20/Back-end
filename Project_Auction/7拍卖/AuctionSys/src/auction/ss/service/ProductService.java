package auction.ss.service;

import auction.ss.entity.Product;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author WM
 * @date 2020/7/9 7:35 下午
 * 描述信息：
 */
public interface ProductService {
    List<Product> showProduct(String name, String description, String startTime, String finalTime, Double basePrice ) throws SQLException;
//    //管理员增加商品
    int addProduct(Product product) throws ParseException, SQLException;
//    //竞拍者竞价
//    int renew(Double price,int id);
    int renewProduct(Product product) throws SQLException, ParseException;
    Product select(int id) throws SQLException;
    int delProduct(int id) throws SQLException, ParseException;
}
