<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee - Employee Tracker</title>
    <link rel="stylesheet" href="assets/css/forms.css">
    <link rel="icon" href="assets/images/logo-small.png">
</head>
<body>

<article class="wrapper">
    <div class="modal">
        <form class="form" action="employee?action=update" method="post">
            <div class="separator">
                <hr class="line">
                <p>Update Employee Form</p>
                <hr class="line">
            </div>
            <input type="hidden" name="id" value="${employee.id}"/>
            <c:if test="${not empty errors && isError}">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-sm-offset-3">
                        <div class="new-message-box">
                            <div class="new-message-box-danger">
                                <div class="info-tab tip-icon-danger" title="error"><i></i></div>
                                <div class="tip-box-danger">
                                    <p>${errors}
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <div class="credit-card-info--form">
                <div class="input-row">
                    <div class="input_container">
                        <label for="first_name" class="input_label">First Name:*</label>
                        <input id="first_name" class="input_field" type="text" name="first_name" value="${employee.firstName}" placeholder="Enter your first name" required>
                    </div>
                    <div class="input_container">
                        <label for="last_name" class="input_label">Last Name:*</label>
                        <input id="last_name" class="input_field" type="text" name="last_name" value="${employee.lastName}" placeholder="Enter your last name" required>
                    </div>
                </div>
                <div class="input-row">
                    <div class="input_container">
                        <label for="email" class="input_label">Email:*</label>
                        <input id="email" class="input_field" type="email" name="email" value="${employee.email}" placeholder="Enter your email" required>
                    </div>
                    <div class="input_container">
                        <label for="phone_number" class="input_label">Phone Number:*</label>
                        <input id="phone_number" class="input_field" type="number" name="phone_number" value="${employee.phone}" placeholder="Enter your phone number" required>
                    </div>
                </div>
                <div class="input-row">
                    <div class="input_container">
                        <label for="department" class="input_label">Department:*</label>
                        <input id="department" class="input_field" type="text" name="department" value="${employee.department}" placeholder="Enter your department name" required>
                    </div>
                    <div class="input_container">
                        <label for="salary" class="input_label">Salary:*</label>
                        <input id="salary" class="input_field" type="number" name="salary" value="${employee.salary}" placeholder="Enter your salary" required>
                    </div>
                </div>
            </div>
            <button class="purchase--btn" type="submit">Update Employee</button>
        </form>
    </div>
</article>
</body>
</html>
