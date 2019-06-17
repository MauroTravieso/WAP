package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userName;
    private String pass;
    private String remember;

    public User(String userName, String pass, String remember) {
        this.userName = userName;
        this.pass = pass;
        this.remember = remember;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public String getRemember() {
        return remember;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public String toString() {
        //return "Id: " + id + " Name: " + name + " Password: " + pass + " Remember: " + remember;
        return "UserName: " + userName + " Password: " + pass + " Remember: " + remember;
    }
}
