<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="width: 100%">

<form class="form-horizontal" role="form" id="addOptionForm" action="javascript:void(null);" method="post" onsubmit="addNewOption()">
    <div class="form-group">
        <label for="type" class="col-sm-2 control-label">Название</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="type" name="type" placeholder="Название" required autofocus>
        </div>
    </div>

    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Стоимость в месяц</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="price" name="price" placeholder="Стоимость в месяц" required>
        </div>
    </div>

    <div class="form-group">
        <label for="connectionPrice" class="col-sm-2 control-label">Стоимость подключения</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="connectionPrice" name="connectionPrice" placeholder="Стоимость подключения" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button  class="btn btn-info" type="submit" value="Сохранить" id="addOption">Сохранить</button></div>
    </div>
</form>
</div>