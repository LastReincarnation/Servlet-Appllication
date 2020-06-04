$(document).ready(function() {

    // 为登录按钮添加点击事件
    $("#login_button").click(function(e) {
        // 查找账号密码对象
        var obj_user = $("#user");
        var obj_password = $("#password");

        //判断登录是否成功
        if (obj_user.val() == "tom" && obj_password.val() == "123") {
            $(location).attr("href", "http://mail.swpu.edu.cn/");
        }
        else if (obj_user.val() == "" && obj_password.val() == "") {
            // 找到登录标题元素对象
            var obj_title = $(".login_title").eq(0);

            if (obj_title) {
                obj_title.html("请填写用户名和密码");
                // 设置新的样式
                obj_title.css("color", "#fff");
                obj_title.css("background-color", "#CC3300");
                obj_title.css("text-align", "center");
                obj_title.css("font-weight", "400");
            }
        } else {
            // 找到登录标题元素对象
            var obj_title = $(".login_title").eq(0);

            if (obj_title) {
                obj_title.html("您填写的账号名或密码错误");
                // 设置新的样式
                obj_title.css("color", "#fff");
                obj_title.css("background-color", "#CC3300");
                obj_title.css("text-align", "center");
                obj_title.css("font-weight", "400");

                // 重置密码
                obj_password.val("");
            }
        }
    });
});