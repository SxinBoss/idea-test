package me.test;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mereyu on 2016-05-07.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        req.setAttribute("name","sxin");
        req.setAttribute("age",18);
        req.setAttribute("title","info");

        req.getRequestDispatcher("/WEB-INF/sxin.jsp").forward(req,resp);*/
        resp.setHeader("content-type","text/html");
        try {
            Class c = Class.forName("me.test.Test");
            Object obj = c.newInstance();
            Method[] mList = c.getMethods();
            for (Method m:mList) {
                resp.getWriter().write(m.getName()+"<hr />");
            }
            resp.getWriter().write("getAge->Ann <hr />");
            Annotation[] maList= c.getMethod("getAge").getAnnotations();
            for(Annotation a :maList){
                resp.getWriter().write(a.toString()+"<hr />");
            }
            resp.getWriter().write("Class->Ann <hr />");
            Annotation[] classList= c.getAnnotations();
            for(Annotation a :classList){
                resp.getWriter().write(a.toString()+"<hr />");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
