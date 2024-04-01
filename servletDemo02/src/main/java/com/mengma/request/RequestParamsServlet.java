package com.mengma.request;

import java.io.IOException;

import java.servlet.ServletException;
import java.servlet.annotation.WebServlet;
import java.servlet.http.Cookie;
import java.servlet.http.HttpServlet;
import java.servlet.http.HttpServletRequest;
import java.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // 此处省略登录验证逻辑
        
        if ("admin".equals(username) && "password".equals(password)) {
            // 登录成功，创建Cookie
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24 * 30); // 设置Cookie有效期为30天
            response.addCookie(cookie);
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}

