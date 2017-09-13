<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

        <form class="form-horizontal" role="form" id="clientContactInfo" action="javascript:void(null);" method="get" onsubmit="sendOrderByAnon()" style="margin-left: 25%; width: 100%">
            <div class="form-group">
                <label for="number" class="col-sm-2 control-label">Введите  контактный номер</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="number" name="client" placeholder="Введите номер" required autofocus>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button class="btn btn-info" type="submit" value="Сохранить" id="addTariff" style="margin-right: 74%">Отправить</button></div>
            </div>
        </form>
</div>
