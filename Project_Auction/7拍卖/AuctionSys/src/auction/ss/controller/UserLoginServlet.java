package auction.ss.controller;

import auction.ss.entity.Adminster;
import auction.ss.entity.User;
import auction.ss.service.AdminService;
import auction.ss.service.Impl.AdminServiceImpl;
import auction.ss.service.Impl.UserServiceImpl;
import auction.ss.service.UserService;

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
 * @date 2020/7/8 5:06 下午
 * 描述信息：
 */
@WebServlet(name = "UserLoginServlet",urlPatterns = "/userLogin.do")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String remember =request.getParameter("rem_me");

        UserService userService = new UserServiceImpl();
        try {
            User user = userService.loginName(loginName,password);
            if(user!=null){
                HttpSession session = request.getSession();

                session.setAttribute("user",user);
                // 登陆成功，跳转拍卖界面
                if(remember!=null){
                    request.getRequestDispatcher("cookie.do").forward(request,response);
                }
                request.getRequestDispatcher("Auction_User.html").forward(request,response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回登录界面
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
