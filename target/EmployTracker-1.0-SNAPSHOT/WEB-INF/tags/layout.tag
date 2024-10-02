<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="style.css"> <!-- Link to your CSS -->
</head>
<body>
<header>
    <h1>My Dynamic JSP Layout</h1>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="about.jsp">About</a>
        <a href="contact.jsp">Contact</a>
    </nav>
</header>

<main>
    <jsp:doBody />
</main>

<footer>
    <p>&copy; 2024 My Website</p>
</footer>
</body>
</html>
