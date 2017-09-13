<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <h3>Вы являетесь клиентом MobileService?</h3>
    <button class="btn btn-warning" onclick="addOrderFromUser(${order.id})" style="margin-right: 5%; margin-top: 3%">Да</button>
    <button class="btn btn-warning" onclick="addOrderFromAnonymous(${order.id})" style="margin-top: 3%">Нет</button>
</div>
