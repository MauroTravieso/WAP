package controllers;

import entity.Question;
import services.FeedService;
import services.ProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    Connection connection;
    public ProfileController() {
        connection = DB.getConnection();
    }

    //Categories
    private ProfileService service;
    @Override
    public void init() throws ServletException {
        service = new ProfileService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Profile page");
        //Mauro
        Integer id = (Integer) req.getSession().getAttribute("userId");
        //resp.getWriter().print("Welcome, " + username);

        // execute sql to collect data from db
        try {
            //Categories
            req.setAttribute("tags", service.getAllTags());
            System.out.println(service.getAllTags());

            // query user data to display on profile
            PreparedStatement statement = connection.prepareStatement("select * from user where id=?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                req.setAttribute("userId", id);
                req.setAttribute("userName", result.getString("username"));
                req.setAttribute("userEmail", result.getString("email"));
            }

            // query question and answer.
            statement = connection.prepareStatement("select * from question where user_id=?");
            statement.setInt(1, id);

            ResultSet rsQuestions = statement.executeQuery();
            ArrayList<Question> questions = new ArrayList<Question>();
            while(rsQuestions.next()){
                Question qs = new Question();
                qs.setId(rsQuestions.getInt("id"));
                qs.setTitle(rsQuestions.getString("title"));
                qs.setCreatedAt(rsQuestions.getDate("created_at").toLocalDate());
                qs.setUpdatedAt(rsQuestions.getDate("updated_at").toLocalDate());
                questions.add(qs);
            }

            req.setAttribute("questions", questions);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("profile.jsp").forward(req, resp);
        //Mauro
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String username = req.getParameter("username");
        //String password = req.getParameter("password");
        //String remember = req.getParameter("remember");
        Integer id = (Integer) req.getSession().getAttribute("userId");
        ArrayList<Question> questions = new ArrayList<Question>();

        try {
            // query user data to display on profile
//            PreparedStatement statement = connection.prepareStatement("select * from user where id=?");
//            statement.setInt(1, id);

//            ResultSet result = statement.executeQuery();
//            while (result.next()) {
//                req.setAttribute("userId", id);
//                req.setAttribute("userName", result.getString("username"));
//                req.setAttribute("userEmail", result.getString("email"));
//            }

            // query question and answer.
            PreparedStatement statement = connection.prepareStatement("select * from question where user_id=?");
            statement.setInt(1, id);

            ResultSet rsQuestions = statement.executeQuery();
            //ArrayList<Question> questions = new ArrayList<Question>();
            while(rsQuestions.next()){
                Question qs = new Question();
                qs.setId(rsQuestions.getInt("id"));
                qs.setTitle(rsQuestions.getString("title"));
                qs.setCreatedAt(rsQuestions.getDate("created_at").toLocalDate());
                qs.setUpdatedAt(rsQuestions.getDate("updated_at").toLocalDate());
                questions.add(qs);
            }

//            req.setAttribute("questions", questions);

        } catch (SQLException e) {
            e.printStackTrace();
        }

//        req.getRequestDispatcher("profile.jsp").forward(req, resp);
        //Mauro

        //Showing statistics
        resp.setContentType("type/plain");
        PrintWriter out = resp.getWriter();
        out.print(questions.size()); // to be sent to the Profile serverlet
        System.out.print("Number of questions posted: " + questions.size());
    }
}
