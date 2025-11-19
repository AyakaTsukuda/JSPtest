package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        // MySQL 接続情報
        String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC";
        String user = "root";
        String password = ""; // --initialize-insecure で作った場合は空パスワード

        try {
            // ドライバ読み込み（8.x以降は不要ですが明示的に書いてもOK）
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 接続
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL 接続成功！");

            // 簡単なクエリで確認
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW();");
            if (rs.next()) {
                System.out.println("サーバ時刻: " + rs.getString(1));
            }

            // クローズ
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
