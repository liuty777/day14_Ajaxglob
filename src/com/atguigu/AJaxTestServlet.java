package com.atguigu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "AJaxTestServlet",value = "/AJaxTestServlet")
public class AJaxTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost!");
        String name = request.getParameter("name");
        System.out.println(name);
        String location = request.getParameter("location");
        System.out.println(location);
        response.getWriter().write("{\"name\":\"John\",\"lc\":\"Boston\"}");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("stuName");
        String location = request.getParameter("stuAge");
        System.out.println(name);
        System.out.println(location);

        //输入流
        response.getWriter().write("{\"stuName\":\"cxk\",\"stuAge\":18}");
    }
}
