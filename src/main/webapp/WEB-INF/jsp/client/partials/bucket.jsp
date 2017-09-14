<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>




            <h3 style="margin-left: 23%; font-family: serif">Вы добавили следующие заявки:</h3>
    <div id="clientChooseContract" style="margin-top: 6%; margin-left: 61px">
    <c:forEach items="${order}" var="order">
        <c:if test="${order.bucket == 0}">
            <div class="col-md-3 col-sm-6" style="width: 45%; margin-top: 20px; margin-left: 5%; height: 235px;">
                <div class="serviceBox1">
                    <div class="service-icon">
                        <i class="fa fa-globe"></i>
                    </div>

                    <div class="service-content">
                        <h3 class="title">${order.description}</h3>
                    </div>
                    <div>
            <button class="btn btn-warning" onclick="addOrderFromUserProfile(${client.id})">Оформить заявку</button></c:if>

        </div>

                </div>
            </div>
    </c:forEach>
    </div>



</div>