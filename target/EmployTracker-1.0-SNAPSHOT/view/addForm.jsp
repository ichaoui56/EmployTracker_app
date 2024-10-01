<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Employee - Employee Tracker</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<header>
    <h1>Ajouter un Employee</h1>
</header>

<main>
    <form action="/EmployTracker_war_exploded/employee?action=insert" method="post">
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="phone_number">Numéro de téléphone:</label>
        <input type="text" id="phone_number" name="phone_number" required><br>

        <label for="department">Département:</label>
        <input type="text" id="department" name="department" required><br>

        <label for="salary">Salaire:</label>
        <input type="number" id="salary" name="salary" required step="0.01"><br>

        <input type="submit" value="Ajouter Employee">
    </form>
</main>

<footer>
    <p><a href="index.jsp">Retour à l'accueil</a></p>
</footer>

</body>
</html>
