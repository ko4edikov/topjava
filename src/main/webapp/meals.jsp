<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Meals</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>


<h3><a href="index.html">Home</a></h3>

<h2>Meals</h2>

<h4><a href="meals?action=add">Add new record</a></h4>
<table class="flat-table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="mealWithExceeded" items="${mealsWithExceeded}">

        <tr id="meal-row" style="${mealWithExceeded.exceed? 'color:red' : 'color:rgb(111, 111, 111)'}">

            <td>${mealWithExceeded.id}</td>
            <td>
                ${dateFormat.format(mealWithExceeded.dateTime)}
            </td>
            <td>${mealWithExceeded.description}</td>
            <td>${mealWithExceeded.calories}</td>
            <td>
                <a href="meals?action=edit&id=${mealWithExceeded.id}">Edit</a>
                |
                <a href="meals?action=delete&id=${mealWithExceeded.id}">Delete</a>
            </td>


        </tr>


    </c:forEach>
    </tbody>
</table>

</body>
</html>