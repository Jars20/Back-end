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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddServlet", urlPatterns = "/add.do")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLoginName(request.getParameter("loginName"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setSex(Integer.valueOf(request.getParameter("sex")));
        user.setEmail(request.getParameter("email"));
        user.setMobile(request.getParameter("mobile"));

        boolean flag = false;
        try {
            IUserDao iUserDao = new UserDaoImpl(JdbcUtils.getConnection());
            int id = iUserDao.add(user);
            if (id > 0) {
                flag = true;
            }
            System.out.println(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<meta charset ='utf-8'>");
        writer.println(flag==true?"成功":"失败");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
