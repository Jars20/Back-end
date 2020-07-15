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

/**
 * @author WM
 * @date 2020/7/11 11:27 上午
 * 描述信息：
 */
@WebServlet(name = "AdminRenewProductServlet",urlPatterns = "/admin_product_renew.do")
public class AdminRenewProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        request.setCharacterEncoding("UTF-8");

        Product product = null;
        try {
            product = productService.select(Integer.parseInt(request.getParameter("productId")));
            System.out.println(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("进入修改页...");
        //数据库中读取到商品。进入修改页面
        HttpSession session =request.getSession();
        session.setAttribute("productRenew",product);
        request.getRequestDispatcher("AdminRenewProduct.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
