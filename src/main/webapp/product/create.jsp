<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/5/2021
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form thêm mới sản phẩm</title>
</head>
<body>
<form action="" method="post">
    <fieldset>
        <legend>From Thêm mới một sản phẩm</legend>
        <table>
            <tr>
<%--                <th>ID</th>--%>
                <th>Name</th>
                <th>Price</th>
                <th>Describe</th>
                <th>Produce</th>
            </tr>
            <tr>
<%--                <td><input type="number" placeholder="ID" name="name"></td>--%>
                <td><input type="text" placeholder="Name" name="name"></td>
                <td><input type="number" placeholder="Prince" name="price"></td>
                <td><input type="text" placeholder="describer" name="desc"></td>
                <td><input type="text" placeholder="Produce" name="produce"></td>
                <td><input type="submit" name="submit"></td>

            </tr>

        </table>
    </fieldset>
</form>

</body>
</html>
