<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Сервисы</title>
    <meta charset="utf-8">
    <meta name="author" content="pixelhint.com">
    <link rel="stylesheet" type="text/css" href="../../assets/css/reset.css">
    <link rel="stylesheet" type="text/css" href="../../assets/css/main.css">
    <script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>



    <!-- Bootstrap core CSS     -->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="../../assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="../../assets/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../../assets/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="../../assets/css/themify-icons.css" rel="stylesheet">
</head>

<body>

<!--  start header  -->
<header>
    <div class="wrapper">
        <a href="index1.jsp">
            <img src="../../assets/img/logo.png" class="logo"/>
        </a>

        <nav>
            <ul>
                <li><a href="/">О компании</a></li>
                <li><a href="/services">Сервисы</a></li>
                <li><a href="#">Корпоративным клиентам</a></li>
                <li><a href="#">Новости</a></li>
                <li><a href="/order/bucket">Корзина</a></li>
                <li><a href="/loginForm">Личный кабинет</a></li>
            </ul>
        </nav>
    </div>
</header>
<!--  end header  -->


<!--  stat page title  -->
<section class="page_title">
    <div class="wrapper" id="addContent">


                <h3 style="margin-top: -6%; font-family: serif">Вы добавили в корзину следующие услуги:</h3>
        <div id="clientChooseContract" style="width: 60%; margin-left: 18%">
                <c:forEach items="${order}" var="order">
                   <%-- <p style="margin-top: 3%"><div>${order.description}</div> <button class="btn btn-warning"  onclick="sendOrderToAdmin(${order.id})" style="margin-left: 6%">Оформить заявку</button>
                    </p>--%>
                    <c:if test="${order.bucket==0}">
                    <div class="col-md-3 col-sm-6" style="width: 45%; margin-top: 20px; margin-left: 5%">
                        <div class="serviceBox1">
                            <div class="service-icon">
                                <i class="fa fa-globe"></i>
                            </div>

                            <div class="service-content">
                                <h3 class="title">${order.description} </h3>
                            </div>
                            <div>
                                <button class="btn btn-warning"  onclick="sendOrderToAdmin(${order.id})" style="margin-left: 6%">Оформить заявку</button>
                            </div>

                        </div>
                    </div>
                    </c:if>
                </c:forEach>
        </div>

    </div>

</section>

<section class="services clearfix">

</section>

<section class="process">
    <div class="wrapper">

    </div>
</section>
<!--  end process section  -->


<!--  start call to action section  -->
<section class="cta">

</section>
<!--  end call to action section  -->


<!--  start footer  -->
<footer>
    <div class="wrapper">

    </div>
</footer>
<!--  end footer  -->



</body>
<script src="../../assets/javascript/clientAccount.js"></script>

<script src="../../assets/javascript/data.js"></script>
<link href="../../assets/lib/select2.min.css" rel="stylesheet">
<script src="../../assets/lib/jquery-3.2.1.js"></script>
<script src="../../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../assets/lib/select2.min.js"></script>
<%--<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>--%>
<link href="../../assets/lib/jquery-ui.css" rel="stylesheet">
<script src="../../assets/lib/jquery-ui.js"></script>
<link href="../../assets/lib/sweetalert.css" rel="stylesheet">
<script src="../../assets/lib/sweetalert-dev.js"></script>
<script src="../../assets/javascript/clientAccount.js"></script>
<script type="text/javascript" src="../../assets/js/jquery.js"></script>
<script type="text/javascript" src="../../assets/js/main.js"></script>

<script type="text/javascript" src="../ga.js"></script>
<!--  Checkbox, Radio & Switch Plugins -->
<script src="../../assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="../../assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../../assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<%--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--%>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="../../assets/js/paper-dashboard.js"></script>
<%--<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script--%>>
<%--
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
--%>
</html>

