<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <div class="flex-box-buttom">
        <div><button type="button" class="btn btn-success active "  onclick="contractInformation(${currectContract.id})" style="width: 150px">Информация </button></div>
        <div><button type="button" class="btn btn-success "  onclick="contractBlock(${currectContract.id})" style="width: 150px; margin-left: 10px">Блокировка</button></div>
        <div><button type="button" class="btn btn-success"  onclick="changeTariffOnAdminDashboard(${currectContract.id})" style="width: 150px; margin-left: 10px">Изменить тариф</button></div>
        <div><button type="button" class="btn btn-success " onclick="optionsForCurrentContract(${currectContract.id})" style="width: 150px; margin-left: 10px">Опции</button></div>
        <div><button type="button" class="btn btn-success " onclick="pageToRemoveContract(${currectContract.id})" style="width: 150px; margin-left: 10px">Удалить контракт</button></div>
    </div>
<div id="addInformationForContract">
    <table class="table table-striped" style="margin-top: 80px; margin-left: 40px" id="contractInformation">
        <tbody>
        <tr>
            <th scope="row">Имя</th>
            <td>${currectContract.client.first_name}</td>
        </tr>
        <tr>
            <th scope="row">Фамилия</th>
            <td>${currectContract.client.second_name}</td>
        </tr>
        <tr>
            <th scope="row">Номер телефона</th>
            <td >${currectContract.number}</td>
        </tr>
        <tr>
            <th scope="row">Номер контракта</th>
            <td >${currectContract.id}</td>
        </tr>
        <tr>
            <th scope="row">Название тарифа</th>
            <td >${currectContract.tariff.name}</td>
        </tr>
        <tr>
            <th scope="row">Подключенные опции </th>
            <td ><ul>
                <li><c:forEach items="${currectContract.options}" var="option">
                        ${option.type}</li>
                </c:forEach></ul>

            </td>
        </tr>
        <tr>
            <th scope="row">Статус контракта</th>
            <c:choose>
                <c:when test="${currectContract.isBlockedByUser == 1}">
                    <td>заблокирован пользователем</td>
                </c:when>
                <c:when test="${currectContract.isBlockedByAdmin == 1}">
                    <td>заблокирован администратором</td>
                </c:when>
                <c:otherwise>
                    <td>активирован</td>
                </c:otherwise>
            </c:choose>

        </tr>
        </tbody>
    </table>
</div>

</div>
