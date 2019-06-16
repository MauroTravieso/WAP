
package controller;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getAttribute("User");//It passes an Object data type
        String act = (String)req.getAttribute("act");
        System.out.println(act);

        req.setAttribute("User", user);
        req.setAttribute("act", act);

        String p1name = req.getParameter("p1name");
        double p1price = Double.parseDouble(req.getParameter("p1price"));
        int p1qty = Integer.parseInt(req.getParameter("p1qty"));
        System.out.println(p1qty);

        String p2name = req.getParameter("p2name");
        Double p2price = Double.parseDouble(req.getParameter("p2price"));
        Integer p2qty = Integer.parseInt(req.getParameter("p2qty"));

        String p3name = req.getParameter("p3name");
        Double p3price = Double.parseDouble(req.getParameter("p3price"));
        Integer p3qty = Integer.parseInt(req.getParameter("p3qty"));

        Double total = p1price*p1qty + p2price*p2qty + p3price*p3qty;
        System.out.println("total amount is: " + total);

        PrintWriter out = resp.getWriter();
        out.print("Checkout successful!");
        out.print("total amount is: " + total);




        //RequestDispatcher rd = req.getRequestDispatcher("/checkout");
        //rd.forward(req,resp);

    }
}

