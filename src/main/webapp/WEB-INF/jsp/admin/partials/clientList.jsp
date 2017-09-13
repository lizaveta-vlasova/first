<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="clientList">
    <input type="text" id="myInput" onkeyup="search()" placeholder="Введите номер паспорта">

    <table class="table table-striped" id="clientList">
        <thead style="font-family: serif">
        <th style="text-align: center;" >ID</th>
        <th style="text-align: center;">ИМЯ</th>
        <th style="text-align: center;">ФАМИЛИЯ</th>
        <th style="text-align: center;">ДАТА РОЖДЕНИЯ</th>
        <th style="text-align: center;">EMAIL</th>
        <th style="text-align: center;">ПАСПОРТ</th>
        <th style="text-align: center;">ПОДКЛЮЧЕННЫЕ НОМЕРА</th>
        <th style="text-align: center;"></th>
        </thead>
        <tbody>
        <tr>
<c:if test="${!empty clientList }">

    <c:forEach items="${clientList}" var="client">
            <th scope="row">${client.id}</th>
        <td style="text-align: center;">${client.first_name}</td>
        <td style="text-align: center;">${client.second_name}</td>
        <td style="text-align: center;">${client.date_of_birth}</td>
        <td style="text-align: center;">${client.email}</td>
        <td style="text-align: center;">${client.passport_number}</td>
        <td style="text-align: center;">
            <ul id="clientListUl">
                <c:forEach items="${client.contracts}" var="contract">
                    <li>
                    <a onclick="getFoundContractByClientList(${contract.number})" href="javascript:void(0)">
                        <i class="ti-pencil-alt"></i>
                        ${contract.number}
                    </a>
                    </li>
                </c:forEach>
            </ul>
        </td>
            <td><a onclick="changeCLientInformation(${client.id})" href="javascript:void(0)">
                <i class="ti-pencil-alt"></i>
                </a>
                <a onclick="deleteClient(${client.id})" href="javascript:void(0)">
                    <i class="ti-trash"></i>
                </a>
            </td>
       </tr>
    </c:forEach>
        </c:if>
        </tbody>
    </table>


</div>
