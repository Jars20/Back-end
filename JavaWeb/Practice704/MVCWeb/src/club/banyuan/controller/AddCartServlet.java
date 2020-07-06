package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddCartServlet",urlPatterns = "/addCart.do")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入购物车");
        int id =Integer.valueOf(request.getParameter("productId"));
        int num =Integer.valueOf(request.getParameter("num"));
        ProductService productService = new ProductServiceImpl();
        Product product = null;
        try {
            product =productService.getProductById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (product!=null){
            HttpSession httpSession = request.getSession();
            Map<Product,Integer> cart = null;
            if (httpSession.getAttribute("cart")==null){
                cart = new HashMap<>();
            }else {
                cart = (HashMap<Product,Integer>)httpSession.getAttribute("cart");
            }

            if(cart.containsKey(product)){
                System.out.println("该商品已在表单中");
                int temp_i = cart.get(product)+num;
                cart.put(product,temp_i);
            }else{
                System.out.println("该订单不包含商品");
                cart.put(product,num);
            }
            httpSession.setAttribute("cart",cart);
        }

        request.getRequestDispatcher("BuyCar.jsp").forward(request,response);
//        request.getRequestDispatcher("Product.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
