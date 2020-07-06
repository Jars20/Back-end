package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductDetailServlet",urlPatterns = "/productDetail.do")
public class ProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("".equals(request.getParameter("id"))||request.getParameter("id")==null){
            System.out.println("id == null");
            request.setAttribute("error","error1_链接错误");
        }
        int id = Integer.valueOf(request.getParameter("id"));
        ProductService productService = new ProductServiceImpl();
        try {
            Product product = productService.getProductById(id);
            if(product!=null){
                request.setAttribute("product",product);
            }else{
             request.setAttribute("error","error2_找不到相关商品");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("Product.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
