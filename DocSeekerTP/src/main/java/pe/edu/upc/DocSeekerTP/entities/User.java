package pe.edu.upc.DocSeekerTP.entities;

public class User {
    private int id;
    private String userName;
    private String password;
    private boolean enable;

    public User(int id, String userName, String password, boolean enable) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }

    public User() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
