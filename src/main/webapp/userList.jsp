<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>ユーザ一覧</h2>
<a href="userAdd">新規登録</a>
<ul>
<%
    java.util.List<org.example.model.User> users =
        (java.util.List<org.example.model.User>) request.getAttribute("users");
    for (org.example.model.User u : users) {
%>
    <li><%= u.getUserName() %> / <%= u.getPassword() %> / <%= u.getEmail() %></li>
<% } %>
</ul>
</body>
</html>
