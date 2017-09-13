<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin-top: 60px; margin-left: 25%">

        <h3 >Блокировать/разблокировать номер</h3>

        <c:choose>
        <c:when test="${currentContract.isBlockedByAdmin == 0}">
        <button class="btn btn-danger" style="margin-left: 90px; margin-top: 20px" value="contractId" onclick="blockByAdmin(${currentContract.id})">Заблокировать номер</button>
        </c:when>
        <c:otherwise>
        <button class="btn btn-danger" style="margin-left: 90px; margin-top: 20px" value="contractId" onclick="unblockByAdmin(${currentContract.id})">Разблокировать номер</button>
        </c:otherwise>
        </c:choose>
</div>