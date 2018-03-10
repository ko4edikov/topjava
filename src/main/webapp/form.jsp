<%--
  Created by IntelliJ IDEA.
  User: ko4edikov
  Date: 08.03.2018
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create record</title>
</head>
<body>
<h2>Create new record</h2>

<form action="meals" method="post">
    <table border="1">
        <tr style="display: none">
            <td><input type="text" name="meal-id" value="${meal.id}" hidden="hidden"/></td>

        </tr>


        <tr>
            <td>Date</td>
            <td><input type="datetime-local" name="meal-datetime" value="${meal.dateTime}"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="meal-description" value="${meal.description}"></td>
        </tr>
        <tr>
            <td>Calories</td>
            <td><input type="number" name="meal-calories" value="${meal.calories}"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Submit</button>
            </td>
        </tr>


    </table>

</form>
</body>
</html>
