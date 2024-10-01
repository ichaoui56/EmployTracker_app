<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home - Employee Tracker</title>
    <link rel="stylesheet" href="css/style.css"> <!-- Link to your CSS file -->
</head>
<body>

<header class="showcase">
    <div class="showcase-top">
        <div class="logo-text">Employee Tracker</div>
        <a href="/EmployTracker_war_exploded/employee?action=showForm" class="btn btn-rounded">Ajouter un employee</a>
    </div>
    <div class="showcase-content">
        <h1>Gestion des Employés</h1>
        <p>Une application web pour gérer les informations de vos employés de manière simple.</p>
        <a href="#" class="btn btn-xl">
            Afficher les Employés
            <i class="fas fa-chevron-right btn-icon"></i>
        </a>
    </div>
</header>

</body>
</html>
