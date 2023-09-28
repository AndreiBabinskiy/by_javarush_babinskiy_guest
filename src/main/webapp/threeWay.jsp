<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2023
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Three Way</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="static/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<style>
    body {
        background-image: url('image/imageThreeWay.jpeg');
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<form class="row g-1" style="padding-left: 10px;" action="four-servlet" method="POST">
    <div style="padding-left: 5px; padding-top: 5px;">
        <div style="width: 40rem; color: blue" class=" badge bg-warning badge text-center">
            <h1> Ты поднялся на мостик. Ты кто ?</h1>
        </div>
    </div>
    <hr style="color: chartreuse" class=" border-5 opacity-75">
    <div class="form-group">
        <label class="col-md-2 control-label fst-italic fs-4">Выбери вариант:</label>
        <div class="col-md-4" style="padding-left: 20px;">
            <div class="radio fw-semibold fs-5">
                <label for="radios-0">
                    <input type="radio" name="three-way" id="radios-0" value="one-choice">
                    Рассказать правду о себе
                </label>
            </div>
            <div class="radio fw-semibold fs-5" >
                <label for="radios-1">
                    <input type="radio" name="three-way" id="radios-1" value="two-choice" checked>
                    Солгать о себе
                </label>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <button style="border:5px greenyellow  solid;width: 100px; height: 50px;"type="submit" value="result-second-way" class="btn btn-success">Ответить</button>
    </div>
    <div style="padding-left: 200px;" class="col-md-6">
        <image style="border:5px blue  solid; width: 300px; height: 300px;border-radius: 30%;" src="image/imageQA.png" />
    </div>
</form>
<div style=" padding-top: 10px; padding-left: 10px" class="fs-5">
    <div style="border:5px red  solid; padding-left: 10px; width:300px;">
        <% String s = (String) session.getAttribute("ipaddress");%>
        <p> Ip address: <%=s%> </p>
        <% String a = (String) session.getAttribute("name-twoWay");%>
        <p> Имя в игре: <%=a%> </p>
        <% Integer count = (Integer) session.getAttribute("countWay");%>
        <p> Количетво игр: <%=count%> </p>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
