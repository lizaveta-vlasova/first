<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="clientList">

    <table class="table table-striped" id="clientList">
        <thead style="font-family: serif">
        <th style="text-align: center;" >ID</th>
        <th style="text-align: center;">УСЛУГА</th>
        <th style="text-align: center;">КЛИЕНТ</th>
        <th style="text-align: center;">СТАТУС</th>
        <th style="text-align: center;"></th>
        </thead>
        <tbody>
        <tr>
            <c:if test="${!empty orderList }">

            <c:forEach items="${orderList}" var="order">
            <th scope="row">${order.id}</th>
            <td style="text-align: center;">${order.description}</td>
            <td style="text-align: center;">${order.client}</td>
                <td style="text-align: center;">${order.status}</td>

            <td>
                <a onclick="changeOrderStatus(${order.id})" href="javascript:void(0)">
                    <i class="ti-check"></i>
                </a>
            </td>
        </tr>
        </c:forEach>
        </c:if>
        </tbody>
    </table>


</div>

