<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.09.2023
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Final</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="static/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<style>
    body {
        background-image: url('image/imageEnd.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<form  class="row g-1" style="padding-left: 170px; padding-top: 150px;" action="final-servlet" method="POST">
    <div style="padding-left: 15px; padding-top: 20px;">
        <div class="badge bg-info text-center" style="border:5px blue  solid; width: 70rem; height: 150px;">
            <h1 style="color: black"> Ты не пошёл на переговоры.</h1>
            <h1 style="padding-left: 20px; color: red">Поражение !</h1>
        </div>
    </div>
    <div class="col-md-4" style="padding-left: 200px; padding-top: 70px;">
        <button style="border:5px greenyellow  solid; width: 170px; height: 60px;" name="result-final" type="submit" value="result-finalOne-way" class="btn btn-success">Сыграть ещё раз</button>
    </div>
    <div class="col-md-4" style="padding-left: 370px; padding-top: 70px;">
        <button style="border:5px mediumvioletred  solid; width: 170px; height: 60px;" name="result-final" type="submit" value="result-finalTwo-way" class="btn btn-danger">Сменить игрока</button>
    </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
