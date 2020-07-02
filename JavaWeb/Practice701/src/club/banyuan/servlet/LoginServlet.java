package club.banyuan.servlet;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.enity.User;
import club.banyuan.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/registe.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");

        try {
            IUserDao iUserDao = new UserDaoImpl(JdbcUtils.getConnection());
            User user = iUserDao.getLoginUser(loginName,password);
            if (user!=null){
                System.out.println("登录成功");
            }else{
                System.out.println("请输入正确的账号以及密码！");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
