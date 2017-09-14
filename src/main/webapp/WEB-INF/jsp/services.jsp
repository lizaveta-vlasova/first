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
    <div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
        <!-- Индикаторы для карусели -->
        <ol class="carousel-indicators">
            <!-- Перейти к 0 слайду карусели с помощью соответствующего индекса data-slide-to="0" -->
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <!-- Перейти к 1 слайду карусели с помощью соответствующего индекса data-slide-to="1" -->
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <!-- Перейти к 2 слайду карусели с помощью соответствующего индекса data-slide-to="2" -->
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- Слайды карусели -->
        <div class="carousel-inner">
            <!-- Слайды создаются с помощью контейнера с классом item, внутри которого помещается содержимое слайда -->
            <div class="active item">
                <h2>Слайд №1</h2>
                <div class="carousel-caption">
                    <h3>Заголовок 1 слайда</h3>
                    <p>Текст (описание) 1 слайда...</p>
                    <img src="https://images.pexels.com/photos/32237/pexels-photo.jpg?w=1260&h=750&auto=compress&cs=tinysrgb">
                </div>
            </div>
            <!-- Слайд №2 -->
            <div class="item">
                <h2>Slide 2</h2>
                <div class="carousel-caption">
                    <h3>Second slide label</h3>
                    <p>Aliquam sit amet gravida nibh, facilisis gravida odio.</p>
                </div>
            </div>
            <!-- Слайд №3 -->
            <div class="item">
                <h2>Slide 3</h2>
                <div class="carousel-caption">
                    <h3>Third slide label</h3>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                </div>
            </div>
        </div>
        <!-- Навигация для карусели -->
        <!-- Кнопка, осуществляющая переход на предыдущий слайд с помощью атрибута data-slide="prev" -->
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <!-- Кнопка, осуществляющая переход на следующий слайд с помощью атрибута data-slide="next" -->
        <a class="carousel-control right" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
</section>
<!--  end page title  -->


<!--  start services section  -->
<section class="services clearfix">
    <div class="wrapper">
        <ul>
            <li>
                <h1>Мобильное ТВ</h1>
                <p>С Мобильным ТВ вы можете начать просмотр захватывающего фильма или передачи на домашнем телевизоре, затем отправиться в любимое кафе и смотреть на смартфоне, а если он вдруг разрядится, продолжить на планшете или ноутбуке.</p>
                <button class="btn btn-warning" formmethod="post" onclick="addOrder('Мобильное TV')">Добавить</button>
            </li>
            <li style="height: 367px">
                <h1>Кабельное телевидение</h1>
                <p>Смотрите фильмы, спортивные трансляции и передачи в хорошем качестве без помех. Дополнительное оборудование не понадобится.</p>
                <button class="btn btn-warning" onclick="addOrder('кабельное TV')">Добавить</button>
            </li>
            <li>
                <h1>Домашнее телевидение</h1>
                <p>Интерактивное ТВ — это новейший формат телевидения. Просмотр телепередач и фильмов станет еще более удобным и увлекательным, а Ваш телеэкран превратится в настоящий центр развлечений для всей семьи.Подключите интернет и ТВ в одном пакете. Экономьте до 40% ежемесячно.</p>
                <button class="btn btn-warning" onclick="addOrder('интерактивное TV')">Добавить</button>
            </li>
            <li>
                <h1>Тарифы
                    домашней телефонии</h1>
                <p>Оставайтесь на связи с теми, кто Вам дорог! Действует специальное предложение: 190 ₽/мес в пакете с телевидением и интернетом</p>
                <button class="btn btn-warning" onclick="addOrder('домашняя телефония')">Добавить</button>
            </li>
            <li>
                <h1>Мультирум</h1>
                <p> Подключайте Цифровое ТВ на все телевизоры в квартире на условиях вашего тарифного плана. Любимые пакеты каналов будут транслироваться на каждом экране у вас дома, а единый для всех устройств счет избавит вас от путаницы с оплатой услуг.</p>
                <button class="btn btn-warning" onclick="addOrder('multiroom')">Добавить</button>
            </li>
            <li>
                <h1>Мне нравится</h1>
                <p>Высокоскоростной интернет и максимум каналов по минимальной цене при заключении контракта на 24 мес. Цена фиксирована и не изменится.</p>
                <button class="btn btn-warning" onclick="addOrder('выгодный интернет')">Добавить</button>
            </li>
        </ul>
    </div>
</section>
<!--  end services section  -->


<!--  start process section  -->
<section class="process">
    <div class="wrapper">
        <h2 class="title">Our Process</h2>
        <ul>
            <li>
                <div class="stages">
                    <img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/research_icon.png" alt="" title=""/>
                    <h3>Research</h3>
                </div>
                <hr class="process_sep"/>
            </li>
            <li>
                <div class="stages">
                    <img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/design_icon.png" alt="" title=""/>
                    <h3>Research</h3>
                </div>
                <hr class="process_sep"/>
            </li>
            <li>
                <div class="stages">
                    <img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/develop_icon.png" alt="" title=""/>
                    <h3>Research</h3>
                </div>
                <hr class="process_sep"/>
            </li>
            <li>
                <div class="stages">
                    <img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/test_icon.png" alt="" title=""/>
                    <h3>Research</h3>
                </div>
                <hr class="process_sep"/>
            </li>
            <li>
                <div class="stages">
                    <img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/launch_icon.png" alt="" title=""/>
                    <h3>Research</h3>
                </div>
            </li>
        </ul>
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
        <p class="copyrights"> <a href="http://pixelhint.com" target="_blank" class="website">Pixelhint.com</a> All Rights Reserved.</p>

        <ul class="social">
            <li>
                <a href="http://www.facebook.com/pixelhint" target="_blank"><img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/fb_icon.png" alt="" title=""></a>
            </li>
            <li>
                <a href="http://www.twitter.com/pixelhint" target="_blank"><img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/twitter_icon.png" alt="" title=""></a>
            </li>
            <li>
                <a href="#" target="_blank"><img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/google_icon.png" alt="" title=""></a>
            </li>
            <li>
                <a href="#" target="_blank"><img src="../../../../../../../../Users/жюба/Desktop/Creativs/img/rss_icon.png" alt="" title=""></a>
            </li>
        </ul>
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
