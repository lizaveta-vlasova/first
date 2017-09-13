<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="flex-container" id="flex-container" style="margin-top: 60px">

        <c:if test="${!empty tariffOptions}">

            <c:forEach items="${tariffOptions}" var="tariffOption">
                <div class="col-md-4" style="width: 300px;">
                    <div class="pv-30 ph-20 service-block bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                        <span class="icon bg-df circle"><i class="fa fa-diamond"></i></span>
                        <h3>${tariffOption.type}</h3>
                        <div class="divider clearfix"></div>
                        <%--<p>ID: ${tariff.id}</p>--%>
                            <%--<a href="page-services.html"><i class="pl-5 fa fa-angle-double-right"></i></a>--%>
                        <div class="flex-button-addTariff">
                            <div style="padding: 5%">
                                                    <c:choose>
                                                        <c:when test="${currentContract.options.contains(tariffOption)}">
                                                            <button  class="btn btn-outlined btn-info" style="width: 65%" value="optionId" onclick="deleteOptionForClientContract( ${tariffOption.optionId},${currentContract.id})">Удалить опцию</button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button  class="btn btn-outlined btn-info" style="width: 65%" value="optionId" onclick="addOptionForClientContract( ${tariffOption.optionId},${currentContract.id})">Добавить опцию</button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>

                            </div>
                        </div>
                    </div>
            </c:forEach>
        </c:if>
                </div>


</div>
