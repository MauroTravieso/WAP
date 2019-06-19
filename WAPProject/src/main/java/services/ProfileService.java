package services;

import controllers.DB;
import entity.Feed;
import entity.Question;
import entity.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfileService {
    Connection connection;

    public ProfileService() {
        connection = DB.getConnection();
    }

    public List<Tag> getAllTags() {
        List<Tag> tags = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select count(*) as count,id,question_id, tag from question_tag group by tag");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                Tag tag = new Tag();
                tag.setId(results.getInt("id"));
                tag.setQuestionId(results.getInt("question_id"));
                tag.setTag(results.getString("tag"));
                tags.add(tag);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tags;
    }

    public List<Question> getFeedsByTag(String tag) {

        List<Question> questions = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from question WHERE id IN (SELECT question_id FROM question_tag WHERE tag = ?)");
            statement.setString(1, tag);

            ResultSet results = statement.executeQuery();
            while (results.next()) {
                Question question = new Question();
                question.setId(results.getInt("id"));
                question.setCreatedAt(results.getDate("created_at").toLocalDate());
                question.setTitle(results.getString("title"));
                questions.add(question);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return questions;
    }
}