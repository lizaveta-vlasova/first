<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="width: 100%">
    <form class="form-horizontal" role="form" id="addTariffForm" action="javascript:void(null);" method="post" onsubmit="addNewTariff()">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Название</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="name" name="name" placeholder="Название" required autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">Абонентская плата</label>
            <div class="col-sm-4">
                <input type="text" minlength="2" class="form-control" id="price" name="price" placeholder="Стоимость в месяц" required>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">Описание тарифа</label>
            <div class="col-sm-4">
                <textarea type="text" maxlength="300" class="form-control" id="description" name="description" placeholder="Описание тарифа" required>
                </textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button  class="btn bg-info" type="submit" value="Сохранить" id="addTariff">Сохранить</button></div>
        </div>
    </form>
</div>