package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=GB2312");
        request.setCharacterEncoding("GB2312");
        PrintWriter writer = response.getWriter();
        String strName = request.getParameter("txtName");
        String strPwd = request.getParameter("txtPwd");
        //writer.println("您好!" + strName + "<br>");
        //writer.close();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 注册驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;DatabaseName=NEWS_SYSTEM",
                    "test", "123456");
            stmt = conn.createStatement();
            String sql = "select * from USERS where stuName='"+strName+"' and stuPwd='"+strPwd+"'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                writer.println("您好！" + strName + "<br> " +"密码"+ strPwd + "<br>");
                HttpSession session =request.getSession(true);
            } else {
                writer.println("用户名或密码出现错误");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        Cookie cStuName = new Cookie("stuName", strName);
        cStuName.setMaxAge(60*60*24*30);
        response.addCookie(cStuName);

        Cookie cStuPwd = new Cookie("stuPwd", strPwd);
        cStuPwd.setMaxAge(60*60*24*30);
        response.addCookie(cStuPwd);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
