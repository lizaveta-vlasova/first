<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>

    <div >
        <div>
            <h3 style="text-align: center; font-family: serif" id="block">Блокировка/разблокировка контракта</h3>
        </div>
        <div>
            <c:choose>
                <c:when test="${currentContract.isBlockedByUser == 0}">
                    <button  id="button" style="margin-left: 38%; margin-top: 5%" class="btn btn-danger" value="contractId" onclick="blockByUser(${currentContract.id})">Заблокировать номер</button>
                </c:when>
                <c:otherwise>
                    <button  id="button" style="margin-left: 38%; margin-top: 5%" class="btn btn-success" value="contractId" onclick="unblockByUser(${currentContract.id})">Разблокировать номер</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>
