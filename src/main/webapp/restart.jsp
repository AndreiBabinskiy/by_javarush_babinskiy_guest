<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2023
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restart</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="static/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<style>
    body {
        background-image: url('image/houseI.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<form  class="row g-1" style="padding-left: 170px; padding-top: 100px;" action="restart-servlet" method="POST">
    <div style="padding-left: 15px; padding-top: 100px;">
        <div class="badge bg-primary text-center" style="width: 70rem; height: 150px;">
            <h1 style="color: coral"> Тебя вернули домой.</h1>
            <h1 style="padding-left: 20px; color: lawngreen">Победа !</h1>
            <image style="border:5px yellow  solid; width: 250px; height: 250px;border-radius: 50%;" src="image/house.gif"/>
        </div>
    </div>
    <div class="col-md-4" style="padding-left: 100px; padding-top: 70px;">
        <button style="border:5px orangered  solid; width: 200px; height: 100px;" name="result-restart" type="submit" value="result-restartOne-way" class="btn btn-warning">Сыграть ещё раз</button>
    </div>
    <div class="col-md-4" style="padding-left: 420px; padding-top: 70px;">
        <button style=" border:5px mediumvioletred  solid; width: 200px; height: 100px;" name="result-restart" type="submit" value="result-restartTwo-way" class="btn btn-danger">Сменить игрока</button>
    </div>
</form>
<div style=" padding-top: 2px; padding-left: 10px" class="fs-5">
    <div style="border:5px greenyellow  solid; padding-left: 10px; width:300px; color: white">
        <% String s = (String) session.getAttribute("ipaddress");%>
        <p> Ip address: <%=s%> </p>
        <% String a = (String) session.getAttribute("name-threeWay");%>
        <p> Имя в игре: <%=a%> </p>
        <% Integer count = (Integer) session.getAttribute("countWay");%>
        <p> Количетво игр: <%=count%> </p>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
