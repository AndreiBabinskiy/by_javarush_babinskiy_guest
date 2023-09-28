<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Final Project Module Three</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="static/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<style>
    body {
        background-image: url('image/space.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<body class="fs-6">
    <div style="padding-left: 5px; padding-top: 5px;">
        <div class="badge bg-warning text-center" style="width: 15rem;">
            <h1>Пролог</h1>
        </div>
    </div>
    <hr class="border border-success border-3 opacity-75">
    <div class="text-center" style="color: aliceblue">
        <p class="fw-semibold fs-5">Ты стоишь в космическом порту и готов подняться на борт своего корабля. Разве ты не об этом мечтал? Стать капитаном</p>
        <p class="fw-semibold fs-5">галактического судна с экипажом, который будет совершать подвиги под твоим командованием.</p>
        <p class="fw-semibold fs-5">Так что вперед!</p>
    </div>
    <div style="padding-left: 5px; padding-top: 5px;" class="row g-1">
        <div class="badge bg-info text-center" style="width: 30rem;">
            <h1>Знакомство с экипажом</h1>
        </div>
        <div style="padding-left: 50px;" class="col-md-6">
            <image style="border:5px greenyellow  solid; width: 70px; height: 70px;border-radius: 50%;" src="image/imageStart.jpg" />
        </div>
    </div>
    <hr class="border border-warning border-3 opacity-75">
    <div class="text-center" style="color: aliceblue">
        <p class="fw-semibold fs-5">Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:</p>
        <p class="fw-semibold fs-5">- Здраствуйте, командир ! Я Зинаиса - ваша помощница. Видите ? Там в углу пьет кофе наш Штурман - сержант Бабинский Андрей,</p>
        <p class="fw-semibold fs-5">под штурвалом спит наш бортмеханик - Чёрный Василий, а фотографирует его Сергей Шнуров - наш навигитор.</p>
    </div>
    <p class="fw-semibold fs-4" style="color: crimson">А как обращаться к вам ?</p>
<form class="row g-1" style="padding-left: 10px;" action="first-servlet" method="POST">

        <div class="col-md-2">
            <input name="name-human" type="text" class="form-control input-md">
            <span class="help-block">Введи своё имя</span>
        </div>
        <div class="col-md-4">
            <button style="border:5px greenyellow  solid;" type="submit" value="result-start-way" class="btn btn-success">Представиться</button>
        </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>