/*
---------------------------
-Click on the Button Join !-
---------------------------
*/


var t = 0;

function join_1(name, password) {
    if (t == 0) {
        document.querySelectorAll('.cont_letras > p')[0].style.left = '200px';
        document.querySelectorAll('.cont_letras > p')[1].style.left = '-320px';
        document.querySelectorAll('.cont_letras > p')[2].style.left = '200px';
        setTimeout(function () {
            document.querySelector('.cont_join').className = 'cont_join cont_join_form_act';
        }, 1000);
        t++;
    } else {
        t++;
        document.querySelector('.cont_form_join').style.bottom = '-420px';
        document.querySelector('.cont_join').className = 'cont_join cont_join_form_act cont_join_finish';
        setTimeout(function () {
            toLogin(name, password)
        }, 4000);
    }

}

function toLogin(name, password) {

    var params = {
        "name": name,
        "password": password,
    };

    httpPost("/toLogin", params);
}

//发送POST请求跳转到指定页面
function httpPost(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = "post";
    temp.style.display = "none";

    for (var x in PARAMS) {
        var opt = document.createElement("textarea");
        opt.name = x;
        opt.value = PARAMS[x];
        temp.appendChild(opt);
    }

    document.body.appendChild(temp);
    temp.submit();

    return temp;
}