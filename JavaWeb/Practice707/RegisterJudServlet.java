package club.banyuan.controller;

import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author WM
 * @date 2020/7/7 7:02 下午
 * 描述信息：
 */
@WebServlet(name = "RegisterJudServlet",urlPatterns = "/ValidateUserName.do")
public class RegisterJudServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("触发ajax");
        String result = "true";
        String LoginName = request.getParameter("LoginName");
        System.out.println(LoginName);
        if(LoginName!=""&&LoginName!=null){
            UserService userService = new UserServiceImpl();
            try {
                if(userService.ValidateLoginName(LoginName)){
                    result = "false";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        PrintWriter writer = response.getWriter();

        writer.print(result);

        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
