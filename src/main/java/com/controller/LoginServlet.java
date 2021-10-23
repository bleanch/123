package com.controller;

import com.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.html")
                .forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("pwd");
        String url;
        if("aaa".equals(username)&&"123456".equals(password)){
            User u=new User("王小明");
            request.getSession().setAttribute("user",u);
            url="/welcome";
        }
        else
        {
            url="/login";
        }
        response.sendRedirect(request.getContextPath()+url);
    }
}
