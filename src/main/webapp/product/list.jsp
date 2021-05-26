<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/5/2021
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<a href="/ProductServlet?action=create">Thêm mới</a>
<br>
<form action="" method="post">
    <fieldset>
        <legend>Danh Sách Sản Phẩm</legend>
        <table border="1" width="70%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>describer</th>
                <th>Producer</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach items="${danhsach}" var="list">
                <tr>
                    <td>${list.getId()}</td>
                    <td>${list.getName()}</td>
                    <td>${list.getPrice()}</td>
                    <td>${list.getDescribe()}</td>
                    <td>${list.getProducer()}</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>
            </c:forEach>


        </table>
    </fieldset>
</form>

</body>
</html>
