package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("User");//It passes an Object data type

        String act = (String)req.getAttribute("act");
        System.out.println(act);

        //UserDAO userDao = new UserDAO(); Later to work with the DAO information

        //System.out.println(user.getUserName());
        String userName = req.getParameter("uname");
        String userPassword = req.getParameter("upassword");
        String userRemember = req.getParameter("uremember");

        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8'/><title>Response</title></head><body>");
        out.print("<form action='index.jsp' method='get'>");
        if(act.equals("Login")) {
            System.out.println("Login button was pressed");
            System.out.print("here!!!");
            out.print("<p>Welcome, " + userName + "</p></br>");
            //RequestDispatcher rd=req.getRequestDispatcher("/cart.jsp");
            //rd.include(req, resp);

        } else {
            System.out.println("Guest button was pressed");
            System.out.print("here!!!");
            out.print("<p>Welcome, Guest</p></br>");
            //RequestDispatcher rd=req.getRequestDispatcher("/cart.jsp");
            //rd.include(req, resp);
        }
        out.print("<input value='Log out' type='submit'/><br/>");
        out.print("</form>");
        out.print("</body></html>");

        RequestDispatcher rd=req.getRequestDispatcher("/cart.jsp");
        rd.include(req, resp);

//        out.print("<p></p><input value='Log out' type='submit'/><br/>");
//        out.print("</form>");
//        out.print("</body></html>");

    }
}
