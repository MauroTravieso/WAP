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
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    User user;
    UserDAO userDao = new UserDAO();
    List<User> usersList = new ArrayList<>();
    //static int id=0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //HttpSession session = req.getSession();
        String userName = req.getParameter("uname");
        String userPassword = req.getParameter("upassword");
        String userRemember = req.getParameter("uremember");

        String act = req.getParameter("act");
//        if(act==null){
//            //no button was selected
//        } else if (act.equals("Login")) {
//            System.out.println("Login button was pressed");
//            if (userName!="" && userPassword!=""){
//                userDao.addUser(new User(userName, userPassword, userRemember));
//                usersList = userDao.getAllUsers();
//                for(User ul : usersList) {
//                    System.out.println(ul.toString()+" ");
//                }
//                System.out.println();
//            }
//
//        } else {
//            System.out.println("Guest button was pressed");
//        }

          userDao.addUser(new User(userName, userPassword, userRemember));
//        //id++;
//        usersList = userDao.getAllUsers();
//        for(User ul : usersList) {
//            System.out.println(ul.toString()+" ");
//        }
//        System.out.println();

        PrintWriter out = resp.getWriter();
//        out.println("Login Servlet");
//        out.println("Welcome, " + userName);

//        out.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8'/><title>Response</title></head><body>");
//        out.print("<form action='index.jsp' method='get'>");
//        if(act.equals("Login")) {
//            out.print("<p>Welcome, " + userName + "</p></br>");
//        } else {
//            out.print("<p>Welcome, Guest</p></br>");
//        }
//        out.print("<p></p><input value='Log out' type='submit'/><br/>");
//        out.print("</form>");
//        out.print("</body></html>");

        //Session management

        req.setAttribute("User", user);
        req.setAttribute("act", act);

        RequestDispatcher rd = req.getRequestDispatcher("shop");
        rd.forward(req,resp);


    }
}
