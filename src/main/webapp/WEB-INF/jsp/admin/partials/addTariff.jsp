<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <div class="flex-box-buttom">
        <div>
            <button type="button" class="btn btn-info active" id="addTariffLeftButton " onclick="addTariff()" style="width: 300px">Все тарифы</button></div>
        <div><button type="button" class="btn btn-info" id="addTariffRightButton" onclick="createNewTariff()" style="width: 300px">Создать тариф</button></div>
    </div>
    <section>
        <div class="flex-container" id="flex-container">
<c:if test="${!empty tariffList}">

    <c:forEach items="${tariffList}" var="tariff">
            <div class="row">
                <div class="col-md-4" style="width: 300px;">
                    <div class="pv-30 ph-20 service-block bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100">
                        <span class="icon bg-df circle"><i class="fa fa-diamond"></i></span>
                        <h3>${tariff.name}</h3>
                        <div class="divider clearfix"></div>
                        <p>ID: ${tariff.id}</p>
                        <%--<a href="page-services.html"><i class="pl-5 fa fa-angle-double-right"></i></a>--%>
                        <div class="flex-button-addTariff">
                            <div style="padding: 5%">
                        <button  value="tariffId" onclick="removeTariff(${tariff.id})" class="btn btn-outlined btn-info" style="width: 65%">

                                Удалить </button></div>
                        <div><button  value="tariffId" onclick="editTariff(${tariff.id}) " class="btn btn-outlined btn-info">

                                Редактировать</button></div>
                        </div>
                    </div>
                </div>
            </div>
    </c:forEach>
</c:if>
        </div>
    </section>


