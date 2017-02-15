package src.rps.server;

import java.io.Serializable;
import java.util.Date;

public class Msg implements Serializable{

    private String login;
    private String message;
    private String[] users;
    private Date time;

    public Msg(String login, String message){//for client
        this.login = login;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    public Msg(String login, String message, String[] users){
        this.login = login;
        this.message = message;
        this.users = users;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    public String getLogin() {
        return login;
    }

    public String getMessage() {
        return message;
    }

    public String[] getUsers() {
        return users;
    }

    public Date getTime() {
        return time;
    }
}
