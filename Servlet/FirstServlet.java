import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Support</title></head><body>");
        out.print("<form method='post'>");
        out.print("<h2>CS Department Help Form</h2>");
        out.print("<p>Name:</p> <input name='uname' type='text' />");
        out.print("<p>Email address:</p> <input name='umail' type='text' />");
        out.print("<p>Problem:</p> <select name='uproblem_info'>");
        out.print("<option selected>Select issue</option>");
        out.print("<option>Urgent</option>");
        out.print("<option>Can Wait For Response</option>");
        out.print("</select>");
        out.print("<p>Problem description:</p><textarea name='' id='' cols='40' rows='5'></textarea>");
        out.print("<br/><input type='submit' value='help'/>");
        out.print("</form>");
        out.print("<body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Get the parameters sent to the server
        PrintWriter pw=resp.getWriter();
        resp.setContentType("text/html");

        String userName = req.getParameter("uname");
        String userEmail = req.getParameter("umail");
        String userProblem = req.getParameter("uproblem_info");

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000) + 1;

        //Context Init parameters - Slide 14/32 (Introduction to Servlet)
        ServletContext sc = this.getServletContext();
        String email = sc.getInitParameter("support-email");

        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8'/><title>Test</title></head><body>");
        out.print("<p>Postback received </p>");
        out.print("<p>Thank you! "+userName+" for contacting us!</p>");
        out.print("<p>You should receive reply from us with in 24 hrs in your email address: "+userEmail+".</p>");
        out.print("<p>Let us know in our support email: "+email+" if you don't receive reply within 24 hrs. </p>");
        out.print("<p>Please be sure to attach your reference \"support_ticket_id\" = " +randomInt+ " in your email</p>");
        out.print("</body></html>");
    }
}
