<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/5/2021
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form Xoá sản Phẩm</title>
</head>
<body>
<form action="" method="post">
    <fieldset>
        <legend>Form Xoá Sản Phẩm</legend>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Describer</th>
                <th>Producer</th>
            </tr>
            <tr>
                <td><input value="${product.name}"></td>
                <td><input value="${product.price}"></td>
                <td><input value="${product.describer}"></td>
                <td><input value="${product.producer}"></td>
                <td><input type="submit" value="Delete"></td>
            </tr>

        </table>
    </fieldset>
</form>

</body>
</html>
