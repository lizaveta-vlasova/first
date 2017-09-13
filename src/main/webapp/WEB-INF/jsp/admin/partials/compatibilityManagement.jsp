<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="flex-container" id="flex-container-remove-Option">
        <%-- <div class="row">--%>
        <c:if test="${!empty optionList}">
            <c:forEach items="${optionList}" var="option">
                <div class="col-md-4" style="width: 300px;">
                    <div class="pv-30 ph-20 service-block bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100" id="removeoptionN">
                        <span class="icon bg-df circle"><i class="fa fa-diamond"></i></span>
                        <h3>${option.type}</h3>
                        <div class="divider clearfix"></div>
                        <div class="flex-button-addTariff">
                            <div style="padding: 5%">
                                <button  value="tariffId" onclick="choose(${option.optionId})" class="btn btn-outlined btn-info" style="width: 65%">

                                    Выбрать </button></div>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
