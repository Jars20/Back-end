package club.banyuan.service;

import club.banyuan.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        //注册
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入注册用户名：");
            String name = sc.nextLine();
            System.out.println("请输入注册用密码：");
            String password = sc.nextLine();

            try {
                if(register(name,password)){
                    System.out.println("注册成功！");
                    break;
                }else {
                    System.out.println("注册失败！");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static boolean register(String loginName, String password) throws SQLException {
        Connection conn = JdbcUtils.getConnection(null);
        String sql = "insert into user (id,loginName,password) values (null,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,loginName);
        pstmt.setString(2,password);

        int count = 0;
        count+=pstmt.executeUpdate(sql);
        if(count>0){
            JdbcUtils.close(conn,pstmt);
            return true;
        }else {
            JdbcUtils.close(conn,pstmt);
            return false;
        }

    }
}
