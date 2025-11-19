package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=Asia/Tokyo&useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPass = "";

    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ← これでドライバを明示的にロード
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() throws SQLException {
        List<User> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                list.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email")));
            }
        }
        return list;
    }

    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO users(username,email) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        }
    }
}
