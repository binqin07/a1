package cn.tedu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "RegServlet",urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        System.out.println(username+":"+password);
        try{System.out.println("注册完成");
            String sql="insert into  user values(null,?,?) ";
            Connection conn= DBUtil.getConn();


            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
            System.out.println("注册完成");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw=response.getWriter();
            pw.println("注册成功");
            pw.close();
            conn.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
