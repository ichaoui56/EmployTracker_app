<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit Employee</title>
  <link rel="stylesheet" type="text/css" href="style.css"> <!-- Optional CSS for styling -->
</head>
<body>
<h1>Edit Employee</h1>

<form action="employee" method="post">
  <input type="hidden" name="id" value="${employee.id}">

  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${employee.name}" required><br><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${employee.email}" required><br><br>

  <label for="phone_number">Phone Number:</label>
  <input type="text" id="phone_number" name="phone_number" value="${employee.phone}" required><br><br>

  <label for="department">Department:</label>
  <input type="text" id="department" name="department" value="${employee.department}" required><br><br>

  <label for="salary">Salary:</label>
  <input type="number" step="0.01" id="salary" name="salary" value="${employee.salary}" required><br><br>

  <input type="hidden" name="action" value="update">
  <button type="submit">Update Employee</button>
</form>

<br>
<a href="employee?action=showEmployees">Back to Employee List</a>
</body>
</html>
