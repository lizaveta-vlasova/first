<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>




            <h3 style="margin-left: 23%">Вы добавили следующие заявки:</h3>
    <c:forEach items="${order}" var="order">
        <c:if test="${order.bucket == 0}">${order.description}
            <button class="btn btn-warning" onclick="addOrderFromUserProfile(${client.id})">Оформить заявку</button></c:if>
    </c:forEach>



</div>