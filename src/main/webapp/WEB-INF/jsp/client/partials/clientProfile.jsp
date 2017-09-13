<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="clientProfile">
    <div class="container" style="width: 600px">



                        <h3 style="text-align: center; margin-left: -10%; font-family: serif" id="nameUser">Информация о клиенте: ${client.first_name} ${client.second_name}</h3>

                    <div class="panel-body">
                        <div class="row">
                            <div class=" col-md-9 col-lg-9 ">
                                <table class="table table-hover">
                                    <tbody>
                                    <tr>
                                        <td>ID</td>
                                        <td>${client.id}</td>
                                    </tr>
                                    <tr>
                                        <td>Дата рождения:</td>
                                        <td>${client.date_of_birth}</td>
                                    </tr>
                                    <tr>
                                        <td>Номер паспорта</td>
                                        <td>${client.passport_number}</td>
                                    </tr>

                                    <tr>
                                    <tr>
                                        <td>Адрес</td>
                                        <td>${client.address}</td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td>${client.email}</td>
                                    </tr>
                                    <td>Подключенные номера</td>
                                    <c:forEach items="${client.contracts}" var="contract">
                                        <td style="display: block">${contract.number}</td>
                                    </c:forEach>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
    </div>
</div>
