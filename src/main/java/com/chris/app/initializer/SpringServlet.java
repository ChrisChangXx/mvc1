package com.chris.app.initializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @创建人 zhanghui
 * @创建时间 2021/5/18
 * @描述
 */
public class SpringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = SpringServlet.class.getResource("/").getPath();
        String fileName = request.getRequestURI();
        String path = basePath + fileName;

        File file= new File(path);
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[2048];
        inputStream.read(bytes);

        inputStream.close();
        String str = new String(bytes);
        System.out.println(str);
        response.setContentType("text/html");
        response.getWriter().write(str);
    }
}
