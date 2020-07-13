package auction.ss.controller;

import auction.ss.entity.Adminster;
import auction.ss.service.AdminService;
import auction.ss.service.Impl.AdminServiceImpl;

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
 * @date 2020/7/8 5:05 下午
 * 描述信息：
 */
@WebServlet(name = "AdminLoginServlet",urlPatterns = "/AdminLogin.do")
public class AdminLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");

        System.out.println("Admin"+loginName+password);
        AdminService adminService = new AdminServiceImpl();
        try {
            Adminster adminster = adminService.loginAdmin(loginName,password);
            if(adminster!=null){
                HttpSession session = request.getSession();

                session.setAttribute("admin",adminster);
                //登陆成功，跳转管理员界面,id_1用来标记登录的身份
                session.setAttribute("id_1","Administer");
                request.getRequestDispatcher("search_product.do").forward(request,response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回登录界面
        request.setAttribute("message","pwdError");
        request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
