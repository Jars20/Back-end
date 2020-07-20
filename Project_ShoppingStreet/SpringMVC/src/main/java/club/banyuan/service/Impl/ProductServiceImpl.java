package club.banyuan.service.impl;

import club.banyuan.dao.ProductDao;
import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    public List<Product> getProductByName(String proName) throws Exception {
        return productDao.getProductByName(proName);
    }

    public Product getProductById(int id) throws Exception {
        return productDao.getProductById(id);
    }
}