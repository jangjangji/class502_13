package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        //System.out.println("안녕");
        System.out.println("doGet()");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }

   /* @Override
    public void init() throws ServletException {
        System.out.println("init()");
    }

    */

    @Override
    public void init(ServletConfig config) throws ServletException {
        String key1 = config.getInitParameter("key1");
        String key2 = config.getInitParameter("key2");
        System.out.printf("key1=%s , key2 = %s%n" ,key1,key2);
        String common1 = config.getInitParameter("common1");
        String common2 = config.getInitParameter("common2");
        System.out.printf("com1 =%s, com2 = %s%n",common1,common2);

    }

}