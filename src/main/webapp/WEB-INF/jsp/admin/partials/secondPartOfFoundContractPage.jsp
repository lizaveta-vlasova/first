<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<table class="table table-striped" style="margin-top: 80px; margin-left: 40px" id="contractInformation">
    <tbody>
    <tr>
        <th scope="row">Имя</th>
        <td>${currentContract.client.first_name}</td>
    </tr>
    <tr>
        <th scope="row">Фамилия</th>
        <td>${currentContract.client.second_name}</td>
    </tr>
    <tr>
        <th scope="row">Номер телефона</th>
        <td >${currentContract.number}</td>
    </tr>
    <tr>
        <th scope="row">Номер контракта</th>
        <td >${currentContract.id}</td>
    </tr>
    <tr>
        <th scope="row">Название тарифа</th>
        <td >${currentContract.tariff.name}</td>
    </tr>
    <tr>
        <th scope="row">Подключенные опции </th>
        <td ><ul>
            <c:forEach items="${currentContract.options}" var="option">
            <li>
                    ${option.type}</li>
            </c:forEach></ul>

        </td>
    </tr>
    <tr>
        <th scope="row">Статус контракта</th>
        <c:choose>
            <c:when test="${currentContract.isBlockedByUser == 1}">
                <td>заблокирован пользователем</td>
            </c:when>
            <c:when test="${currentContract.isBlockedByAdmin == 1}">
                <td>заблокирован администратором</td>
            </c:when>
            <c:otherwise>
                <td>активирован</td>
            </c:otherwise>
        </c:choose>

    </tr>
    </tbody>
</table>

