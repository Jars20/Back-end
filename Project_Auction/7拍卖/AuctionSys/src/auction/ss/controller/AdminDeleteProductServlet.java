package auction.ss.controller;

import auction.ss.service.Impl.ProductServiceImpl;
import auction.ss.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author WM
 * @date 2020/7/11 11:27 上午
 * 描述信息：
 */
@WebServlet(name = "AdminDeleteProductServlet",urlPatterns = "/admin_product_delete.do")
public class AdminDeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        request.setCharacterEncoding("UTF-8");
        try {
            System.out.println("待删除货号： "+Integer.parseInt(request.getParameter("productId")) +" 删除成功");
            productService.delProduct(Integer.parseInt(request.getParameter("productId")));

            request.setAttribute("message","delSuccess");
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        request.setAttribute("id_2","Administer");
        request.getRequestDispatcher("search_product.do").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
