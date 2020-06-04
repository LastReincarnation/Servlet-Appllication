function  getCookie(name) {
    var arr,reg = new RegExp("(^| )"+name+"([^;]*)(;|$)");
    if(arr==document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return "";
}
function  checkCookie() {
    var userName = getCookie("txtName");
    var userPwd = getCookie("txtPwd");
    console.log(userName);
    console.log(userPwd);
    alert(userName);
    alert(userPwd);
    if(userName != "" && userPwd !="")
    {
        document.getElementById('user').value=userName;
        document.getElementById('password').value=userPwd;
    }
    window.onload=function () {
        checkCookie();
    }
}