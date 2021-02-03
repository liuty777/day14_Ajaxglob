package com.atguigu.servlet;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "FileDownloadDemoServlet",value = "/FileDownloadDemoServlet")
public class FileDownloadDemoServlet extends HttpServlet {
    /**
     * 实现文件下载
     *  准备下载资源
     *  创建输入流[FileInputStream]
     *  获取输出流[ServletOutputStream]
     *  边读变写
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        //注意 如果正在网页中点超链接下载数据，显示artifacts等路径找不到 则要在out中的项目中把download加上
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取下载资源文件名
        String fileName = request.getParameter("fileName");
        //获取文件本地真实路径
        String realPath = getServletContext().getRealPath("/WEB-INF/download/" + fileName);
        System.out.println(realPath);
        File file = new File(realPath);
        //创建输入流[FileInputStream]
        FileInputStream fis = new FileInputStream(file);
        //边读边写[设置]
        //设置浏览器响应体文件类型
        String mimeType = request.getServletContext().getMimeType(fileName);
        response.setContentType(mimeType);
        //解决文件名中文乱码问题
        String header = request.getHeader("User-Agent");
        if(header!=null && header.contains("Firefox")){
            fileName = "=?utf-8?B?"+new BASE64Encoder().encode(fileName.getBytes("utf-8"))+"?=";

        }else{
            fileName = URLEncoder.encode(fileName,"UTF-8");



        }
        //设置浏览器响应体内容格式，为附件格式.(告诉浏览器，文件为附件，别打开，下载。)
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //获取输出流[ServletOutputStream]
        ServletOutputStream ops = response.getOutputStream();
        //边读边写
        byte[] b = new byte[1024];
        int len;
        while((len=fis.read(b))>0){
            ops.write(b,0,len);
        }
        ops.close();
        fis.close();


    }
}
