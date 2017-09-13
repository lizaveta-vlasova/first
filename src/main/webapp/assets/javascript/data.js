function formdata(data){
    /* если не заполнено поле Ваше имя, длина менее 3-x*/
    if (data.first_name.value.leng)
    {
        alert('Заполните поле "Ваше имя"');
        return false;}

    /* если не заполнено поле Сообщение */
    if (data.second_name != null && data.second_name.value.length < 3)
    {
        alert('Заполните поле "Фамилия"');
        return false;}

    /* e-mail Юзера */
    if(data.date_of_birth != null && data.date_of_birth.value.length == 0)
    {
        alert('Заполните поле "Дата рождения"');
        return false;}

    if(data.passport_number != null && data.passport_number.value.length < 6)
    {
        alert('введите данные паспорта');
        return false;}

    if(data.address != null && data.address.value.length < 6)
    {
        alert('введите верный адрес');
        return false;}

    /* контактный телефон */
    if(data.email != null && data.email.value.length == 0)
    {
        alert('введите Email');
        return false;}

    if(data.phone != null && data.phone.value.length < 5)
    {
        alert('поле "Контактный телефон" должно содержать минимум пять символов');
        return false;}

    if(!(/^[0-9-+()s]+z/.test(data.phone.value+"z")))
    {
        alert('"Контактный телефон" указан неверно');
        return false;}

    /* делаем чтобы поле сумма было равно определенному числу */
    number = document.getElementById("summa");
    if (number.value !== '20')
    {
        alert('"Сумма" не введена или введена неверно');
        return false;}
}
