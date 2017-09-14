<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../../../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../../../assets/img/favicon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
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

        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="/" class="simple-text" style="margin-bottom: -16px">
                    MobileService
                </a>
            </div>

            <ul class="nav" id="clientNavUI">
                <li id="liChooseContract">
                    <a href="/clientAccount/chooseContract">
                        <i class="ti-panel"></i>
                        <p>Ваши контракты</p>
                    </a>
                </li>
                <li id="liUserInformation">
                    <a onclick="userInformation(${contract.client.id})" href="javascript:void(0)">
                        <i class="ti-user"></i>
                        <p>Профиль</p>
                    </a>
                </li>
                <li id="liTariffChange">
                    <c:choose>
                        <c:when test="${isContractBLocked == true}">

                            <a><i class="ti-pencil-alt"></i>
                                <p style="color: darkgrey">Смена тарифа</p></a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="tariffChange(${contractId})" href="javascript:void(0)">
                                <i class="ti-pencil-alt"></i>
                                <p>Смена тарифа</p></a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li id="liOptionsChange">
                    <c:choose>
                        <c:when test="${isContractBLocked == true}">
                            <a><i class="ti-pencil-alt"></i>
                            <p style="color: darkgrey">Опции</p></a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="optionsChange(${contractId})" href="javascript:void(0)">
                                <i class="ti-pencil-alt"></i>
                                <p>Опции</p></a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li id="liNumberBlock">
                    <c:choose>
                    <c:when test="${isContractBlockedByAdmin == true}">
                    <a>
                        <i class="ti-unlock"></i>
                        <p style="color: darkgrey">Блокировать номер</p>
                    </a>
                    </c:when>
                        <c:otherwise>
                            <a onclick="numberBlock(${contractId})" href="javascript:void(0)">
                            <i class="ti-unlock"></i>
                            <p>Блокировать номер</p>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li id="liLogOut">
                    <a href="<c:url value="/logout" />">
                        <i class="ti-share-alt"></i>
                        <p>Выйти</p>
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
                        ${contract.client.first_name} ${contract.client.second_name}, добро пожаловать!</i></div>                </div>
                <div class="collapse navbar-collapse">


                </div>
            </div>
        </nav>


        <div class="content" id="content">
            <div class="container-fluid">
                <div class="row">

                    <div class="infoAboutContract">
                        <h3 style="font-family: serif; text-align: center; margin-left: -160px"> Вы выбрали контракт для номера <b>${contract.number}</b></h3>
                        <c:choose>
                            <c:when test="${isContractBlockedByAdmin == true}">
                                <h3 style="text-align: center; font-family: serif; margin-left: -18%" id="numberBlock">Номер заблокирован администратором.</h3>
                            </c:when>
                            <c:when test="${isContractBlockedByUser == true}">
                                <h3 style="text-align: center; font-family: serif" id="numberBlock">Номер заблокирован.</h3>
                            </c:when>
                            <c:otherwise>
                                <p style="text-align: center; margin-left: -160px" id="please">Пожалуйста, выберете действие в боковом меню.</p>
                            </c:otherwise>
                        </c:choose>


                    </div>


                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">


            </div>
        </footer>

    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="../../../assets/javascript/data.js"></script>
<link href="../../../assets/lib/select2.min.css" rel="stylesheet">
<script src="../../../assets/lib/jquery-3.2.1.js"></script>
<script src="../../../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../../assets/lib/select2.min.js"></script>
<%--<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>--%>
<link href="../../../assets/lib/jquery-ui.css" rel="stylesheet">
<script src="../../../assets/lib/jquery-ui.js"></script>
<link href="../../../assets/lib/sweetalert.css" rel="stylesheet">
<script src="../../../assets/lib/sweetalert-dev.js"></script>
<script src="../../../assets/javascript/clientAccount.js"></script>





<!--  Checkbox, Radio & Switch Plugins -->
<script src="../../../assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="../../../assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../../../assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<%--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--%>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="../../../assets/js/paper-dashboard.js"></script>
<%--<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script--%>>
<%--
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
--%>

</html>

