
function login() {
    var msg = $('#loginForm').serialize();

    var formData = {};
    $("#loginForm").serializeArray().map(function(x){
        formData[x.name] = x.value;
    });

    var headers = {
        authorization: "Basic " + btoa (formData.email + ":" + formData.password)
    };


    $.ajax({
        type: 'GET',
        url: "/login",
        headers: headers,
        data: msg,
        success: function (data, textStatus) {
            window.location.replace('/login');
        }
    });
}