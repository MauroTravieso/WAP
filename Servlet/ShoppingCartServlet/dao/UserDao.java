package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.User;

public class UserDAO {

    //Map<Integer, User> usersDb = new HashMap<>();
    HashMap<String, User> usersDb = new HashMap<>();
//    public void addUser(User user){
//        usersDb.put(user.getId(),user);
//    }

    public void addUser(User user){
        usersDb.put(user.getUserName(),user);
    }

    public void deleteUser(int id) {
        usersDb.remove(id);
    }

//    public void updateUser(User user) {
//        usersDb.put(user.getId(),user);
//    }

    public List<User> getAllUsers() {
        return new ArrayList<>(usersDb.values());
    }

//    public User getUserById(int id) {
//        return usersDb.get(id);
//    }

    public int getSize() {
        return usersDb.size()+1;
    }


}