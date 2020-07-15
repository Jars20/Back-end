package club.banyuan.dao;


import club.banyuan.entity.Product;

import java.text.ParseException;
import java.util.List;

/**
 * @author WM
 * @date 2020/7/9 5:08 下午
 * 描述信息：
 */
public interface IProductDao {
    //增加商品
    int addProduct(Product product) throws ParseException;
    int deleteProduct(int id) throws ParseException;


    //标记已售出
    int sellProduct(int id);
    //标记流拍
    int passProduct(int id);


    //更新id商品的最高出价。表示竞拍
//    public int renewPrice(Double price,int id);
    //管理员更新商品
    int renewProduct(Product product) throws ParseException;



    Product selectById(int id);
    List<Product> showProduct(Product product);

}
