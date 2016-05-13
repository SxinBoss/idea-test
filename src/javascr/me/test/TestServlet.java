package me.test;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;

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
import java.util.List;

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
               /*     resp.getWriter().write("getAge->Ann <hr />");
            Annotation[] maList= c.getMethod("getAge").getAnnotations();
            for(Annotation a :maList){
                resp.getWriter().write(a.toString()+"<hr />");
            }
            resp.getWriter().write("Class->Ann <hr />");
            Annotation[] classList= c.getAnnotations();
            for(Annotation a :classList){
                resp.getWriter().write(a.toString()+"<hr />");
            }*/
        /*
        resp.setHeader("content-type","text/html");
        String getURI=req.getRequestURI();
        getURI=getURI.replace("/sxin/","");
        try {
            Class c = Class.forName("me.test.Test");
            Object obj = c.newInstance();
            Method[] mList = c.getMethods();
            for (Method m:mList) {
                m.invoke(obj,req,resp);
                Annotation[] annotations=m.getAnnotations();
                for(Annotation annotation : annotations){
                    TestAnnotation testAnnotation = (TestAnnotation) annotation;
                    if(getURI.equals(testAnnotation.name()))
                        req.getRequestDispatcher("/WEB-INF/sxin.jsp").forward(req,resp);
                    resp.getWriter().write("<hr />");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        resp.setHeader("Content-type","text/html");
        XMLConfiguration xml = new XMLConfiguration();
        try {
            String filePath =this.getClass().getClassLoader().getResource("sxin.xml").toString();
            xml.load(filePath);

            write(resp,filePath);
            write(resp,"<hr />");
            List<ConfigurationNode> rcList=xml.getRoot().getChildren("test");

            for (ConfigurationNode c:rcList) {
                write(resp,c.getAttribute(0).getName().toString());
                write(resp,"<hr />");
            }
        } catch (Exception e) {
            write(resp,e.toString());
            e.printStackTrace();
        }
    }
    private void write(HttpServletResponse resp,String string) throws IOException {
        resp.getWriter().write(string);
    }
}
