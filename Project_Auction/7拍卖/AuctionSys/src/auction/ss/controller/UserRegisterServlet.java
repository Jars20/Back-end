package auction.ss.controller;

import auction.ss.service.Impl.UserServiceImpl;
import auction.ss.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/8 5:05 下午
 * 描述信息：
 */
@WebServlet(name = "UserRegisterServlet",urlPatterns = "/userRegister.do")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入注册系统");
        int flag = 0;
        UserService userService = new UserServiceImpl();
        try {
            String addressTemp = request.getParameter("postNum");
            Integer postNum = 0;
            System.out.println("地址值："+request.getParameter("address"));
            if(request.getParameter("address").isEmpty()){
                addressTemp = null;
            }
            if(!request.getParameter("postNum").isEmpty()){

            }else {

            }
            flag =userService.register(
                    request.getParameter("loginName"),
                    request.getParameter("password"),
                    request.getParameter("idNum"),
                    request.getParameter("tel"),
                    addressTemp,
                    postNum
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //依据flag判断跳转回原界面还是用户界面
        if(flag>0){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else
            request.getRequestDispatcher("UserRegister.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
