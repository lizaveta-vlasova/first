<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>

    <form class="form-horizontal" role="form" id="saveNewClientForm" class="contact_form" action="javascript:void(null);" method="post" onsubmit="updateClientInformation()">
        <div class="form-group">
            <label for="first_name" class="col-sm-2 control-label">Имя: </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="first_name" name="first_name" placeholder="${client.first_name}" required autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="second_name" class="col-sm-2 control-label">Фамилия</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="second_name" name="second_name" placeholder="${client.second_name}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="date_of_birth" class="col-sm-2 control-label">Дата рождения</label>
            <div class="col-sm-4">
                <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" placeholder="${client.date_of_birth}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="passport_number" class="col-sm-2 control-label">Номер паспорта</label>
            <div class="col-sm-4">
                <input type="text" minlength="6"  class="form-control" id="passport_number" name="passport_number" placeholder="${client.passport_number}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">Адрес</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="address" name="address" placeholder="${client.address}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="email" name="email" placeholder="${client.email}" required>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Пароль</label>
            <div class="col-sm-4">
                <input type="number" class="form-control" id="password" name="password" placeholder="" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button  class="btn btn-info" type="submit" value="Сохранить" id="addTariff">Сохранить</button></div>
        </div>
    </form>

</div>

