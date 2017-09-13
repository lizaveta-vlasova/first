<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>



    <form class="form-horizontal" role="form" id="saveNewContract" class="contact_form" action="javascript:void(null);" method="post" onsubmit="saveNewContract()">
        <div class="form-group">
            <%--@declare id="tariff"--%><label for="tariff" class="col-sm-2 control-label" style="width: auto; font-family: serif">Выберете тариф</label>
            <div class="col-sm-4" style="margin-left: 48px; margin-top: 5px">
                <select name="tariff" id="tariffDropDow" style="width: 166px">
                    <c:forEach items="${tariffList}" var="tariff">
                        <option value="${tariff.id}">${tariff.name}</option>
                    </c:forEach></select>            </div>
        </div>

        <div class="form-group">
            <%--@declare id="clientid"--%><label for="clientId" class="col-sm-2 control-label" style="width: auto; font-family: serif">Выберете клиента по ID</label>
            <div class="col-sm-4">
                <select name="clientId" id="clientDropDown" style="width: 166px">
                    <c:forEach items="${clientList}" var="client">
                        <option value="${client.id}">${client.id}</option>
                    </c:forEach></select>            </div>
        </div>
        <div class="form-group">
            <%--<label for="number" class="col-sm-2 control-label" style="width: auto">Введите номер</label>
            <div class="col-sm-4" style="margin-left: 59px">
                <input type="text" name="number" id="number"></div>--%>

            <p class="col-sm-2 control-label" style="margin-right: 77px; margin-left: -17px; font-family: serif"><b>Введите номер</b></p>
                    <select class="js-example-basic-single" id="number">

                        <c:forEach items="${numbers}" var="number">
                            <option value="${number.number}">${number.number}</option>
                        </c:forEach>
                    </select>
                </label>


        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button class="btn btn-info" type="submit" value="Сохранить" id="addTariff" style="margin-top: 30px">Сохранить</button></div>
        </div>
    </form>

</div>
