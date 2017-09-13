<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="findContract">
    <div>

        </form>
            <form class="form-horizontal" role="form" id="getFoundContractForm" action="javascript:void(null);" method="get" onsubmit="contractPage()">
                <div class="form-group">
                    <label for="number" class="col-sm-2 control-label">Введите номер</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="number" name="number" placeholder="Введите номер" required autofocus>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button class="btn btn-info" type="submit" value="Сохранить" id="addTariff">Отправить</button></div>
                </div>
            </form>

    </div>
</div>

