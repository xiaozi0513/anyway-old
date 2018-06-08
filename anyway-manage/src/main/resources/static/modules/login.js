layui.use(['form'], function () {
  var $ = layui.$, form = layui.form;

  //登录
  form.on('submit(AW-user-login-submit)', function (obj) {
    $(this).text("登录中...").attr("disabled", "disabled").addClass("layui-disabled");
    $.ajax({
      url: '/sys/login',
      type: 'POST',
      data: obj.field,
      dataType: 'json',
      complete: function () {
        $("#AW-user-login-btn").text("登录").removeAttr("disabled").removeClass("layui-disabled");
      },
      success: function (res) {
        if (res.code == 200) {
          location.href = "/index.html";
        } else {
          layer.msg(res.msg, {offset: '15px', icon: 2});
        }
      }
    });
  });

  //校验
  form.verify({
    username: function (value, item) {
      if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
        return '用户名不能有特殊字符';
      }
      if (/(^\_)|(\__)|(\_+$)/.test(value)) {
        return '用户名首尾不能出现下划线\'_\'';
      }
      if (/^\d+\d+\d$/.test(value)) {
        return '用户名不能全为数字';
      }
    },
    pass: [/^[\S]{6,12}$/, "密码必须6-12位，且不能出现空格"]
  });

  //刷新验证码
  $("body").on("click", "#AW-user-get-vercode", function () {
    $(this);
    this.src = "https://www.oschina.net/action/user/captcha?t=" + (new Date).getTime();
  });


});