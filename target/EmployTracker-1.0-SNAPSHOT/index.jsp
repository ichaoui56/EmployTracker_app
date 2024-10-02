<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Home - Employee Tracker</title>
  <link rel="stylesheet" href="assets/css/style.css"> <!-- Link to your CSS file -->
  <link rel="icon" href="assets/images/logo-small.png">
</head>
<body>

<header class="showcase">
  <div class="showcase-top">
    <div class="logo-text">
      <img class="logo-img" src="assets/images/ET-logo.png" alt="">
    </div>
    <a href="/EmployTracker_war_exploded/employee?action=addForm">
      <button class="cssbuttons-io-button">
        Ajouter un employee
        <div class="icon">
          <svg
                  height="24"
                  width="24"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
          >
            <path d="M0 0h24v24H0z" fill="none"></path>
            <path
                    d="M16.172 11l-5.364-5.364 1.414-1.414L20 12l-7.778 7.778-1.414-1.414L16.172 13H4v-2z"
                    fill="currentColor"
            ></path>
          </svg>


        </div>
      </button>
    </a>
  </div>
  <div class="showcase-content">
    <h1>Gestion des Employés</h1>
    <a href="/EmployTracker_war_exploded/employee?action=showEmployees" class="btn btn-xl">
      Afficher les Employés
      <i class="fas fa-chevron-right btn-icon"></i>
    </a>
  </div>
</header>

</body>
</html>