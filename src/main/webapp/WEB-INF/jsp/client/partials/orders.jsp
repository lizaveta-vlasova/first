<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="clientList">

    <table class="table table-striped" id="clientList" style="width: 50%; margin-left: 21%">
        <thead style="font-family: serif">
        <th style="text-align: center; font-family: serif" >УСЛУГА</th>
        <th style="text-align: center; font-family: serif">СТАТУС</th>
        </thead>
        <tbody>
        <tr>
            <c:if test="${!empty orderList }">

            <c:forEach items="${orderList}" var="order">
            <th scope="row" style="font-family: serif; text-align: center">${order.description}</th>
            <td style="text-align: center; font-family: serif; " >${order.status}</td>

        </tr>
        </c:forEach>
        </c:if>
        </tbody>
    </table>


</div>
