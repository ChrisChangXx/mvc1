package com.chris.app;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * spring应用程序luban
 *
 * @author zhx
 * @创建人 zhanghui
 * @创建时间 2021/5/18
 * @描述
 * @date 2021/05/18
 */
public class SpringApplicationLuban {
    public static void run() {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(9080);
            String sourcePath = SpringApplicationLuban.class.getResource("/").getPath();

            //告诉tomcat我们的源码在哪里
            Context ctx = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
            WebResourceRoot resources = new StandardRoot(ctx);
            resources.addPreResources(
                    new DirResourceSet(resources, "/WEB-INF/classes", sourcePath, "/"));
            ctx.setResources(resources);
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
