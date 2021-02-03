package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "fileDomoServlet",value = "/fileDomoServlet")
//实现文件上传
/**
 * 优化文件上传
 *  1.允许同名文件上传
 *      UUID
 *      时间戳+uesrid
 *  2.设置文件上传时，文件大小的上限。
 */
public class fileDomoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //1.创建DiskFIleItemFactory对象，为创建解析器做准备。
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.创建ServletFileUpload解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //调用parseRequest()方法,将request对象，解析为List<FileItem>
        //获取upload真实路径
        String realPath = getServletContext().getRealPath("/upupload");
        //优化[文件不存在时自动创建]问题
        File fPath = new File(realPath);
        if(fPath.exists()==false){
            fPath.mkdir();
            System.out.println("文件未找到，重新创建了一个文件");
        }
        //设置文件上传上限最大为:100kb   这个方法的单位为B
        upload.setFileSizeMax(102400);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for(FileItem fileItem:fileItems){
                //3.调用FileItem中isFormField(),查找文件参数
                if(fileItem.isFormField()==false){
                    String fName = fileItem.getName();
                    String replace = UUID.randomUUID().toString().replace("-", "");
                    //文件参数，4.调用FileItem中writer()方法，实现文件上传
                    //                      File.separator会自动识别系统中的'/'
                    File file = new File(realPath+File.separator+replace+fName);
                    fileItem.write(file);
                }else{
                    //普通参数
                    System.out.println("普通参数");
                }

            }
            response.getWriter().write("上传成功！");
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            response.getWriter().write("文件最大为100kb!");
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }


    }


}
