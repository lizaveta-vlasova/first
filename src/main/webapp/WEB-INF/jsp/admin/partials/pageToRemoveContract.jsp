<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align: center">
    <h2>Вы уверены что хотите удалить контракт?</h2>
    <button class="btn btn-danger" style="margin-left: 90px; margin-top: 20px" value="contractId" onclick="removeContract(${contractId})">Удалить</button>
</div>
