<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <%--<div class="flex-container-for-edit-tariff" id="flexForAddAndRemoveOptionsForTariff" style="margin-top: 50px">
--%><div class="flex-container" id="flex-container" style="margin-top: 80px">

                        <c:if test="${!empty optionList}">
                            <c:forEach items="${optionList}" var="option">
                        <div class="col-md-4" style="width: 300px; height: 350px; display: flex">
                            <div class="pv-30 ph-20 service-block bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100" style="width: 270px">
                                <span class="icon bg-df circle"><i class="fa fa-diamond"></i></span>
                                <h3>${option.type}</h3>
                                <div class="divider clearfix"></div>

                                    <%--<a href="page-services.html"><i class="pl-5 fa fa-angle-double-right"></i></a>--%>
                                <div class="flex-button-addTariff">
                                    <div style="padding: 5%">

                                        <c:choose>
                                           <%-- <c:when test="${option.incompatibleOptions.equals(tariff.availableOptions)}">
                                                <button class="btn btn-info" value="idOption" onclick="">Несовместимая</button>
                                            </c:when>--%>
                                            <c:when test="${tariff.availableOptions.contains(option)}">

                                                <button class="btn btn-info" value="idOption" onclick="removeOptionsForTariff(${tariff.id}, ${option.optionId})">Удалить опцию</button>

                                            </c:when>
                                            <c:otherwise>

                                                <button class="btn btn-info" value="idOption" onclick="addOptionsForTariff(${tariff.id}, ${option.optionId})">Добавить опцию</button>

                                                    </c:otherwise>
                                        </c:choose>


                                    </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>