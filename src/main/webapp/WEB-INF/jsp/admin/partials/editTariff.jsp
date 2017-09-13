<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="flex-box-buttom-second">
    <div><button type="button" class="btn btn-info active btn-md" id="editTariffLeftButton " onclick="editTariff(${tariff.id})" style="width: 300px">Информация о тарифе</button></div>
<div><button type="button" class="btn btn-info btn-md" id="editTariffCentralButton " onclick="changeDataTariff(${tariff.id})" style="width: 300px">Изменить тариф</button></div>
<div><button type="button" class="btn btn-info btn-md" id="addTariffLeftButton " onclick="addAndRemoveOptionsForTariff(${tariff.id})" style="width: 300px">Выбрать опции</button></div></div>

</div>

<div class="container" id="containerForEditTariff">
    <div class="row">

        <div class="row">
            <div class="col-md-1 text-center" style="width: 90%; margin-top: 50px;">
                <div class="box">
                    <div class="box-content">
                        <h1 class="tag-title">${tariff.name}</h1>
                        <hr />
                        <p style="text-align: left">Абонентская плата: ${tariff.price}</p>
                        <p style="text-align: left">Подключенные опции:</p> <c:forEach items="${tariff.availableOptions}" var="option">
                        <ul style="text-align: left"><li>${option.type}</li></ul></c:forEach>
                        <br />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<div>

                                    Информация о тарифе

                            <div class="panel-body">
                                <p class="editTariff">Название тарифа:  <b>${tariff.name}</b></p>
                                <p class="editTariff">Стоимость тарифа: <b>${tariff.price}</b></p>
                                <p class="editTariff">Подключенные опции:
                                    <c:forEach items="${tariff.availableOptions}" var="option">
                                <ul><li>${option.type}</li></ul></c:forEach>                            </div>

                                    Изменение данных


                                <form role="form" class="form-inline" id="updateTariff" action="javascript:void(null);" method="post" onsubmit="saveEditTariff(${tariff.id})" style="margin-top: 20px">
                                    &lt;%&ndash;@declare id="name"&ndash;%&gt;&lt;%&ndash;@declare id="price"&ndash;%&gt;
                                    <div class="form-group"><label for="name">Введите название:</label><input type="text" name="name"></div>

                                    <div class="form-group"> <label for="price">Введите стоимость:</label><input type="text" name="price"></div>

                                    <div class="form-group"> <input type="submit" value="Сохранить"></div>
                                </form>                            </div>

                                   Добавление/удаление опций для тарифа


                                        <c:if test="${!empty optionList}">
                                            <c:forEach items="${optionList}" var="option">

                                                        <div class="service-content">
                                                            <h3>${option.type}</h3>
                                                        </div>
                                                        <div class="read">
                                                            <c:choose>
                                                                <c:when test="${tariff.availableOptions.contains(option)}">
                                                                    <button  value="idOption" onclick="removeOptionsForTariff(${tariff.id}, ${option.optionId})">Удалить опцию</button>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <button value="idOption" onclick="addOptionsForTariff(${tariff.id}, ${option.optionId})">Добавить опцию</button>
                                                                </c:otherwise>
                                                            </c:choose>

                                            </c:forEach>
                                        </c:if>                 --%>