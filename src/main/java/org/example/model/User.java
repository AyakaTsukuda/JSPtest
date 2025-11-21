package org.example.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String email;

    public User() {}
    public User(int id, String userName, String email, String password) {
        this.id = id; this.userName = userName; this.password = password; this.email = email;
    }

    public int getId() { return id; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
