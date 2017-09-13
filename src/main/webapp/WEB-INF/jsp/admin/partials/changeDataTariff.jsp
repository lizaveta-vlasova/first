<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="width: 100%; margin-top: 60px">
    <form class="form-horizontal" role="form" id="updateTariff" action="javascript:void(null);" method="post" onsubmit="saveEditTariff(${tariff.id})">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label" style="width: 25%">Введите название</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="name" name="name" placeholder="Название" required autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="col-sm-2 control-label" style="width: 25%">Абонентская плата</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="price" name="price" placeholder="Стоимость в месяц" required>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button type="submit" value="Сохранить">Обновить</button></div>
        </div>
    </form>
</div>
