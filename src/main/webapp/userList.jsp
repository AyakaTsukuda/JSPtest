<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <body>
        <h2>ユーザ一覧</h2>
        <form action="userList" method="post">
            <p>検索</p>
            <input type="text" name="search">
            <input type="submit" value="検索">
        </form>
        <a href="userAdd">新規登録</a>
        <ul>
            <%
                java.util.List<org.example.model.User> users =
                    (java.util.List<org.example.model.User>) request.getAttribute("users");
                if (users != null) {
                    for (org.example.model.User u : users) {
            %>
            <li><%= u.getUserName() %> / <%= u.getPassword() %> / <%= u.getEmail() %></li>

            <% }
                } else { %>
                <li>ユーザーは存在しません</li>
            <% } %>
        </ul>
    </body>
</html>
