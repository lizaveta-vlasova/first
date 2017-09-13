<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>MobileMain</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">

    <link href="<c:url value="../../../assets/stylesheets/style.css" />" rel="stylesheet">
    <link href="<c:url value="../../../assets/lib/jquery-ui.css" />" rel="stylesheet">
    <script src="<c:url value="../../../assets/lib/jquery-3.2.1.js" />"></script>
    <script src="<c:url value="../../../assets/lib/jquery-ui.js" />"></script>
    <script src="<c:url value="../../../assets/javascript/clientAccount.js"/>"></script>
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="clientNAV">
    <aside>
        <nav>
            <ul id="clientNavUl" class="aside-menu">
                <li id="liCurrentContracts">
                    <a href="/clientAccount/chooseContract">МОИ КОНТРАКТЫ</a>
                </li>
                <li id="liTariffChange">
                    <a onclick="" href="javascript:void(0)" aria-disabled="true">СМЕНА ТАРИФА</a>
                </li>
                <li id="liOptionsChange">
                    <a onclick="" href="javascript:void(0)" aria-disabled="true">ОПЦИИ</a>
                </li>
                <li id="liNumberBlock">
                    <a onclick="numberBlock(${contractId})" href="javascript:void(0)">БЛОКИРОВКА НОМЕРА</a>
                </li>

            </ul>
        </nav>
    </aside>
</div>

<div id="contractId" class="${contractId}">
</div>

<div id="clientContent" class="clientContent">

    Номер заблокирован
</div>

<jsp:include page="../footerForClient.jsp"/>

</body>
</html>
