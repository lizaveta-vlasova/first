<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <div class="flex-box-buttom">
        <div><button type="button" class="btn btn-info active" id="removeOption" onclick="editOptions()" style="width: 150px; margin-left: 30px">Все опции</button></div>
        <div><button type="button" class="btn btn-info" id="addOption" onclick="createNewOption()" style="width: 150px; margin-left: 30px">Создать опцию</button></div>
        <div><button type="button" class="btn btn-info" id="compatibilityManagement" onclick="compatibilityManagement()" style="width: 150px; margin-left: 30px">Настройка</button></div>
    </div>

        <div class="flex-container" id="flex-container-remove-Option">
                   <%-- <div class="row">--%>
                       <c:if test="${!empty optionsList}">
                       <c:forEach items="${optionsList}" var="option">
                        <div class="col-md-4" style="width: 300px;">
                            <div class="pv-30 ph-20 service-block bordered shadow text-center object-non-visible animated object-visible fadeInDownSmall" data-animation-effect="fadeInDownSmall" data-effect-delay="100" id="removeoptionN">
                                <span class="icon bg-df circle"><i class="fa fa-diamond"></i></span>
                                <h3>${option.type}</h3>
                                <div class="divider clearfix"></div>
                                <p>Стоимость в месяц: ${option.price}</p>
                                <p>Стоимость подключения: ${option.connectionPrice}</p>
                                <div class="flex-button-addTariff">
                                    <div style="padding: 5%">
                                        <button  value="tariffId" onclick="removeOption(${option.optionId})" class="btn btn-outlined btn-info" style="width: 65%">

                                            Удалить </button></div>

                            </div>
                        </div>
                    </div>
                       </c:forEach>
                       </c:if>
        </div>








</div>