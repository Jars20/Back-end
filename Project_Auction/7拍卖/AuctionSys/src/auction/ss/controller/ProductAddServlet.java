package auction.ss.controller;

import auction.ss.entity.Product;
import auction.ss.service.Impl.ProductServiceImpl;
import auction.ss.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author WM
 * @date 2020/7/12 7:17 下午
 * 描述信息：
 */
@WebServlet(name = "ProductAddServlet",urlPatterns = "/addProduct.do")
public class ProductAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        Double basePrice = Double.valueOf(request.getParameter("basePrice"));
        Double lowPrice = Double.valueOf(request.getParameter("lowPrice"));
        String startTime = request.getParameter("startTime");
        String finaTime = request.getParameter("finaTime");
        String description = request.getParameter("description");
        System.out.println("request中传来的数据"+name+" "+basePrice+" "+lowPrice+" "+lowPrice+" "+startTime+" "+finaTime+" "+description);
        Product product = new Product(null,name,description,lowPrice,basePrice,startTime,finaTime,0.0,1,0);


        try {
            productService.addProduct(product);
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("search_product.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
