import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Authentication extends HttpServlet {

    public static String userName;
    public static String userPassword;
    public static String userRemember;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("User remember doGet: " + userRemember);

        HttpSession  session = req.getSession();
        System.out.println(session);

        resp.setContentType("text/html");
        PrintWriter out  = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head><meta charset='utf-8'><title>Authentication</title></head>");
        out.print("<form method='post'>");
        out.print("<body>");
        out.print("<h2>Authentication</h2>");

        if(userRemember==null) {
            out.print("Name:<input name='uname' type='text' /></br>");
            out.print("Password:<input name='upassword' type='password' /></br>");
            out.print("Remember me<input name='uremember' type='checkbox' /></br>");
            out.print("<p></p><input value='Authenticate' type='submit'/></br>");
            out.print("</body>");
            out.print("</html>");

//            //Session
            String str = req.getParameter("uname");

            //Cookie
            Cookie cookie = new Cookie("uname", str);
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            out.print("<br>New cookie: " + cookie.getName()+" "+cookie.getValue()+" "+cookie.getMaxAge()+"\n");

        } else {
            out.print("Name:<input name='uname' type='text' value="+userName+"></br>");
            out.print("Password:<input name='upassword' type='password' value="+userPassword+"></br>");
            out.print("Remember me<input name='uremember' type='checkbox' checked/></br>");
            out.print("<p></p><input value='Authenticate' type='submit'/></br>");
            out.print("</body>");
            out.print("</html>");

            Cookie ck[]=req.getCookies();
            for(int i=0;i<ck.length;i++){
                out.print("<br>Cookie client: "+ck[i].getName()+" "+ck[i].getValue()+" "+ck[i].getMaxAge());//printing name and value of cookie
            }

        }


        //Session
        String str = session.getAttribute("uname").toString();
        System.out.println("Attribute: " + str);

        //Cookie
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //String userName = req.getParameter("uname");
        userName = req.getParameter("uname");

        //String userPassword = req.getParameter("upassword");
        userPassword = req.getParameter("upassword");

        //String userRemember = req.getParameter("uremember");
        userRemember = req.getParameter("uremember");
        //System.out.println("User remember: " + userRemember); //on / null

        String uri = req.getContextPath();

        if (userName.equals("Mauro") && (userPassword.equals("pass"))) {
            //this redirects to welcome.jsp - it works ok

            PrintWriter out = resp.getWriter();
            out.print("<!DOCTYPE html><html lang='en'><head><meta charset='utf-8'/><title>Response</title></head><body>");
            out.print("<form action='/FormAuthentication/authenticate' method='get'>");
            out.print("<p>Welcome, " + userName + "</p></br>");
            out.print("<p></p><input value='Log out' type='submit'/><br/>");
            out.print("</form>");
            out.print("</body></html>");

            //Once the session established, to send the parameters (store them) in the session
            String str = req.getParameter("uname");
            HttpSession session = req.getSession();
            session.setAttribute("uname",str);
            System.out.println("Session (doPost): " + str);

            //Cookie
            Cookie cookie = new Cookie("uname", str);
            cookie.setMaxAge(30*24*60*60);//changing the maximum age to One Month in seconds
            //cookie.setMaxAge(1);//changing the maximum age to One Month in seconds
            // One month (30 days * 24 hours/per day * 60 min/hour * 60 sec/per min)
            resp.addCookie(cookie);

            Cookie cks[]=req.getCookies();
            for(int i=0;i<cks.length;i++){
                out.print("<br>Cookie server: "+cks[i].getName()+" "+cks[i].getValue()+" "+cks[i].getMaxAge());//printing name and value of cookie
            }


        }else{
            resp.sendRedirect(uri + "/loginWithError.html");
            //resp.sendRedirect(uri + "/login.jsp");
        }

    }
}
