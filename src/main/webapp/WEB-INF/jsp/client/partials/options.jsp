<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <h3 style="text-align: center; font-family: serif" id="optionList">Для вашего тарифа доступны следующие опции:</h3>

    <div id="clientChooseContract">
        <c:if test="${!empty tariffOptions}">
            <c:forEach items="${tariffOptions}" var="tariffOption">
                <div class="col-md-3 col-sm-6" style="width: 45%; margin-top: 20px; margin-left: 5%; height: 235px;">
                    <div class="serviceBox1">
                        <div class="service-icon">
                            <i class="fa fa-globe"></i>
                        </div>

                        <div class="service-content">
                            <h3 class="title">${tariffOption.type}</h3>
                        </div>
                        <div>
                            <c:choose>
                                <c:when test="${currentOptions.contains(tariffOption)}">
                                    <button class="btn btn-info read-more" value="idOption" onclick="deleteOption(${contractId}, ${tariffOption.optionId})">Удалить опцию</button>
                                </c:when>
                                <c:otherwise>
                                    <button value="idOption" class="btn btn-info read-more" onclick="addOption(${contractId}, ${tariffOption.optionId})">Добавить опцию</button>
                                </c:otherwise>
                            </c:choose>
                        </div>

                    </div>
                </div>

            </c:forEach>
        </c:if>
    </div>
</div>