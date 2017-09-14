<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../../../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="../../../assets/img/favicon.png">
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css" />
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Личный кабинет</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>


    <!-- Bootstrap core CSS     -->
    <link href="../../../assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="../../../assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="../../../assets/css/paper-dashboard.css" rel="stylesheet"/>

    <link href="../../../assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../../../assets/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="../../../assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="/" class="simple-text" style="margin-bottom: -17px">
                    MobileService
                </a>
            </div>

            <ul class="nav" id="clientNavUI">
                <li class="active">
                    <a href="/clientAccount/chooseContract">
                        <i class="ti-panel"></i>
                        <p >Ваши контракты</p>
                    </a>
                </li>
                <li id="liUserInformation">
                    <a onclick="userInformation(${client.id})" href="javascript:void(0)">
                        <i class="ti-user"></i>
                        <p id="profile" >Профиль</p>
                    </a>
                </li>
                <li id="liBucket">
                    <a onclick="bucket(${client.id})" href="javascript:void(0)">
                        <i class="ti-shopping-cart"></i>
                        <p id="bucket" >Корзина</p>
                    </a>
                </li>
                <li id="liOrders">
                    <a onclick="orders(${client.id})" href="javascript:void(0)">
                        <i class="ti-layers-alt"></i>
                        <p id="orders" >Заявки</p>
                    </a>
                </li>
                <li id="liLogOut">
                    <a href="<c:url value="/logout" />">
                        <i class="ti-share-alt"></i>
                        <p >Выйти</p>
                    </a>
                </li>

            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <div id="name" style="padding-top: 35px"><i class="" style="margin-left: 229px; margin-top: 43px">
                   ${client.first_name} ${client.second_name}, добро пожаловать!</i></div>
                </div>
                <div class="collapse navbar-collapse">

                </div>
            </div>
        </nav>


        <div class="content" id="content">


            <div class="container" id="clientChooseContract">
                                        <c:if test="${!empty contractsList}">
                                        <c:forEach items="${contractsList}" var="contract">
                                        <div class="col-md-3 col-sm-6" style="background: whitesmoke; width: 45%; margin-top: 20px">
                                            <div class="serviceBox1">
                                                <div class="service-icon1"><i class="fa fa-mobile"></i></div>
                                                <h3 class="title">Номер телефона ${contract.number}</h3>
                                                <p class="description">Ваш тариф:${contract.tariff.name}</p>
                                                <p class="description">Статус:
                                                    <c:choose>
                                                        <c:when test="${contract.isBlockedByAdmin == 1}">
                                                заблокирован</p>
                                                        </c:when>
                                                <c:when test="${contract.isBlockedByUser == 1}">
                                                    заблокирован</p>
                                                </c:when>
                                                <c:otherwise>
                                                    активный</p>
                                                </c:otherwise>
                                                </c:choose>
                                                <form action="/clientAccount/${contract.id}" method="get">
                                                    <input type="submit" value="Подробнее" class="btn btn-warning"/>
                                                </form>
                                            </div>
                                        </div>
                                        </c:forEach>
                                        </c:if>

                                </div>

            </div>


        <footer class="footer">

        </footer>

    </div>
</div>


</body>

    <!--   Core JS Files   -->

	<script src="../../../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../../assets/javascript/clientAccount.js"></script>
<link href="../../../assets/lib/jquery-ui.css" rel="stylesheet">
<script src="../../../assets/lib/jquery-3.2.1.js"></script>
<script src="../../../assets/lib/jquery-ui.js"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="../../../assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="../../../assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../../../assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="../../../assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="../../../assets/js/demo.js"></script>





</html>
