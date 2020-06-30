package club.banyuan.service;

import club.banyuan.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：\n");
        String name= sc.nextLine();
        System.out.println("请输入密码：\n");
        String password = sc.nextLine();

        try {
            validate(name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static boolean validate(String name, String password) throws SQLException {
        Connection conn = JdbcUtils.getConnection(null);
        String sql = "select * from user where loginName=? and password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,password);

        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
            JdbcUtils.close(conn,pstmt,rs);
            return true;
        }else{
            System.out.println("账号或密码有误");
            JdbcUtils.close(conn,pstmt,rs);
            return false;
        }
    }
}
