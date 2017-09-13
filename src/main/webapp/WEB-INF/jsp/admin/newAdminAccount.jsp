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
    <title>Администратор</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />



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
    <link href='//fonts.googleapis.com/css?family=Lato:900,400' rel='stylesheet' type='text/css'>


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
                <a href="/">
                    MobileService
                </a>
            </div>

            <ul class="nav" id="clientNavUI">
                <li id="liClientList">
                    <a onclick="clientList()" href="javascript:void(0)">
                        <i class="ti-panel"></i>
                        <p>Список клиентов</p>
                    </a>
                </li>
                <li id="liAddTariff">
                    <a onclick="addTariff()" href="javascript:void(0)">
                        <i class="ti-user"></i>
                        <p>Управление тарифами</p>
                    </a>
                </li>
                <li id="liEditOptions">
                    <a onclick="editOptions()" href="javascript:void(0)">
                        <i class="ti-pencil-alt"></i>
                                <p>Управление опциями</p></a>
                </li>
                <li id="liFindContractPage">
                    <a onclick="findContractPage()" href="javascript:void(0)"><i class="ti-pencil-alt"></i>
                                <p>Поиск контракта</p></a>

                </li>
                <li id="liAddNewClient">
                    <a onclick="addNewClient()" href="javascript:void(0)">
                        <i class="ti-plus"></i>
                        <p>Новый клиент</p>
                    </a>
                </li>
                <li id="liAddNewContract">
                    <a onclick="addNewContract()" href="javascript:void(0)">
                        <i class="ti-plus"></i>
                        <p>Новый контракт</p>
                    </a>
                </li>
                <li id="liOrders">
                    <a onclick="orderList()" href="javascript:void(0)">
                        <i class="ti-bell"></i>
                        <p>Заявки</p>
                    </a>
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
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">Вы находитесь на странице администратора</a>
                </div>
                <div class="collapse navbar-collapse">


                </div>
            </div>
        </nav>


        <div class="content" id="content">
            <div class="container-fluid">
                <div class="row">

                    <h3 style="font-family: serif; text-align: center">Вы находитесь на странице администратора</h3>


                </div>
            </div>
        </div>


        <footer class="footer">

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
<script src="../../../assets/javascript/adminAccount.js"></script>





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


