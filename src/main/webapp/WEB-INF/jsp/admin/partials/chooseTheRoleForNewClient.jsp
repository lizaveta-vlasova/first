<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    Выберете роль для клиента ${client.first_name}:
  <button class="btn btn-info" value="client"  onclick="setAdminRole(${client.id})">Администратор</button>
    <button class="btn btn-info" onclick="setUserRole(${client.id})">Клиент</button>
</div>
