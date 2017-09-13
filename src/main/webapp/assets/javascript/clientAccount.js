$(document).ready(function(){
    if ($("#contractId")[0]) {
        tariffChange($("#contractId")[0].className);
    }
});


function tariffChange(contractId) {
    $.ajax({
        url: '/clientAccount/tariff/'+contractId,          // указываем URL и
        dataType : "html",                     // тип загружаемых данных
        success: function (data, textStatus) { // вешаем свой обработчик на функцию success
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liTariffChange").attr('class', 'active');

            $("#myDialog").dialog({
                autoOpen: false,
                modal: true,
                height: "auto",
                width: 400,
                modal: true,
                buttons: {
                    "Да": function () {
                        $(this).dialog("close");
                        var tariffId = $(this).data('tariffId');
                        window.location.replace('/clientAccount/tariff/' + contractId + '/newTariff/' + tariffId);
                    },
                    "Нет": function () {
                        $(this).dialog("close");
                    }
                }
            });
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liTariffChange").attr('class', 'active');
        }
    });
}
function userInformation(clientId) {
    $.ajax({
        url:'/clientAccount/userInfo/' + clientId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liUserInformation").attr('class', 'active');
        }
    })
}

function orders(clientId) {
    $.ajax({
        url:'/clientAccount/orders/' + clientId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liOrders").attr('class', 'active');
        }
    })
}

function bucket(clientId) {
    $.ajax({
        url:'/clientAccount/bucket/' + clientId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liBucket").attr('class', 'active');
        },
        error:function (xhr, ajaxOptions, thrownError){
            if(xhr.status==500) {
                sweetAlert({
                    title: "Корзина пуста",
                    text: "Отсутствуют выбранные позиции",
                    type: "error"
                });
            }
        }
    })
}
function addOrderFromUserProfile(clientId) {
            window.location.replace('/clientAccount/addOrder/' + clientId);
            sweetAlert({
                title: "Заявка отправлена!",
                text: "Менеджер свяжется с Вами в ближайшее время.",
                type: "success"
            });

            /*$("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liChooseContract").attr('class', 'active')*/
        }




function showTariffChangeConfirmation(tariffId) {
    $("#myDialog")
        .data('tariffId', tariffId)
        .dialog("open");
}

function optionsChange(contractId){
    $.ajax({
        url:'/clientAccount/options/'+contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liOptionsChange").attr('class', 'active');
        }
    })
}

function addOption(contractId, idOption){
    $.ajax({
        url:'/clientAccount/options/' + contractId + '/add/' + idOption,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liOptionsChange").attr('class', 'active');
        }
    })
}

function deleteOption(contractId, idOption){
    $.ajax({
        url:'/clientAccount/options/' + contractId + '/remove/' + idOption,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liOptionsChange").attr('class', 'active');
        }
    })
}

function numberBlock(contractId){
    $.ajax({
        url:'/clientAccount/block/'+contractId ,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liNumberBlock").attr('class', 'active');
        }
    })

}
function blockByUser(contractId){
    window.location.replace('/clientAccount/block/'+contractId +'/blocked/');
    sweetAlert({
        title: "Выполнено",
        text: "Номер заблокирован!",
        type: "success"
    });

}
function unblockByUser(contractId){
    window.location.replace('/clientAccount/block/'+contractId +'/unblocked/');
    sweetAlert({
        title: "Выполнено",
        text: "Номер разблокирован!",
        type: "success"
    });
}





function cleanActiveLiSelection() {
    $('#clientNavUl').find('li').removeClass();
}

function getContractNumer(tariffId) {
    $.ajax({
        url:'/clientAccount/loginTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;

        }
    })
}


function getChangeTariff() {
    $.ajax({
        url:'/clientAccount/chooseTheTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            alert("Изменения успешно сохранены!");

        }
    })

}

function updateTariff(){
    $.ajax({
        url:'/clientAccount/chooseTheContract',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;

        }
    })

}
function addOrder(str){
    var order = str;
    $.ajax({
        type: 'POST',
        url:'/order',
        data : {order: str},
        success: function (data, textStatus) {
            sweetAlert({
                title: "Выполнено",
                text: "Заявка добавлена в корзину!",
                type: "success"
            });

        }
    })

}
function sendOrderToAdmin(orderId) {
    $.ajax({
        url:'/order/sendToAdmin/'+orderId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addContent")[0].innerHTML = data;
        }
    })
}
/*function addOrderFromUser(orderId) {
    $.ajax({
        url:'/order/addOrderByUser/' + orderId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addContent")[0].innerHTML = data;
        }
    })
}*/
function addOrderFromUser() {
    $.ajax({
        url:'/loginForm',
        dataType : "html",
        success: function (data, textStatus) {
            window.location.replace('/loginForm');
            //$("#addContent")[0].innerHTML = data;
        }

    })
}
function addOrderFromAnonymous(orderId) {
    $.ajax({
        url:'/order/addOrderFromAnonymous/'+orderId ,
        dataType : "html",
        success: function (data, textStatus) {
            $(".page_title")[0].innerHTML = data;

        }
    })

}
function sendOrderByAnon() {
    var msg = $('#clientContactInfo').serialize();
    $.ajax({
        type: 'GET',
        url: '/order/clientContactInfo/' + msg ,
        data: msg,
        success: function (data, textStatus) {
            sweetAlert({
                title: "Заявка отправлена!",
                text: "Менеджер свяжется с Вами в ближайшее время.",
                type: "success"
            });
        }
    })
}











