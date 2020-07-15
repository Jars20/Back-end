package auction.ss.controller;

import auction.ss.dao.IProductDao;
import auction.ss.dao.impl.ProductDaoImpl;
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
 * @date 2020/7/11 3:31 下午
 * 描述信息：
 */
@WebServlet(name = "ProductRenewServlet", urlPatterns = "/renewProdcuct.do")
public class ProductRenewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入商品修改页面");
        ProductService productService = new ProductServiceImpl();
        request.setCharacterEncoding("UTF-8");
        //构造更新过的product


        String name = request.getParameter("name");
        Double basePrice = Double.valueOf(request.getParameter("basePrice"));
        Double lowPrice = Double.valueOf(request.getParameter("lowPrice"));
        String startTime = request.getParameter("startTime");
        String finaTime = request.getParameter("finaTime");
        String description = request.getParameter("description");
//        System.out.println("request中传来的数据"+name+" "+basePrice+" "+lowPrice+" "+lowPrice+" "+startTime+" "+finaTime+" "+description);

        HttpSession session=request.getSession();
        Product productOrg = (Product)session.getAttribute("productRenew");
        Product product = new Product(productOrg.getId(),name,description,lowPrice,basePrice,startTime,finaTime,productOrg.getHighPriceTemp(),productOrg.getOnSell(),productOrg.getSoldOrNot());
        try {
            productService.renewProduct(product);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
//        request.setAttribute("message","renewSuccess");
        response.sendRedirect("search_product.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
