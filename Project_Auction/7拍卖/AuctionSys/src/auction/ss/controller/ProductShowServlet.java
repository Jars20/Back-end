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
import java.util.List;

/**
 * @author WM
 * @date 2020/7/9 8:20 下午
 * 描述信息：
 */
@WebServlet(name = "ProductServlet", urlPatterns = "/search_product.do")
public class ProductShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        request.setCharacterEncoding("UTF-8");


        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String startTime = request.getParameter("startTime");
            String finalTime = request.getParameter("finalTime");
            Double basePrice = null;
            if(request.getParameter("basePrice")!=null) {
                basePrice = Double.valueOf(request.getParameter("basePrice"));
            }

            List<Product> productList =productService.showProduct(name,description,startTime,finalTime,basePrice);
            request.setAttribute("products",productList);
            request.setAttribute("size",productList.size());
            //判断进入哪一个详情页
            HttpSession session = request.getSession();


            String id = (String)session.getAttribute("id_1");
            System.out.println("进入菜单界面，访问身份为"+id);
            //此处打印搜索的关键字，如果不输入则为五个null
            System.out.println("此处打印搜索的关键字，如果不输入则为五个null "+name + description + startTime + finalTime + basePrice);
            if("Administer".equals(id)){
                request.getRequestDispatcher("Auction_Admin.jsp").forward(request,response);
            }else if("User".equals(id)){
                request.getRequestDispatcher("Auction_User.jsp").forward(request,response);
            }else {
                System.out.println("身份信息错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
