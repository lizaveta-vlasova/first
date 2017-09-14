<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="clientChooseContract">
    <c:if test="${!empty tariffList}">
        <c:forEach items="${tariffList}" var="tariff">
    <div class="col-md-3 col-sm-6" style="width: 45%; margin-top: 20px; margin-left: 5%">
        <div class="serviceBox1">
            <div class="service-icon">
                <i class="fa fa-globe"></i>
            </div>

            <div class="service-content">
                <h3 class="title">${tariff.name} </h3>
                <p class="description">
                    Абонентская плата ${tariff.price}
                </p>
            </div>
            <div>
                <c:choose>
                    <c:when test="${currentTariffId == tariff.id}">
                        <button onclick="" class="btn btn-info" style="width: 172px" name="tariff">Действующий тариф</button>
                    </c:when>
                    <c:otherwise>
                        <button value="tariffId" style="width: 172px" class="btn btn-info" onclick="showTariffChangeConfirmation(${tariff.id})">Сменить тариф</button>
                    </c:otherwise>
                </c:choose>

            </div>

        </div>
    </div>

    </c:forEach>
    </c:if>>
    <div id="myDialog" title="Dialog box">
        <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;">
        </span>Вы уверены, что хотите перейти на этот тариф?</p>
    </div>

</div>
